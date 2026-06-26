package com.aivle.cultureapp.service;

import com.aivle.cultureapp.dto.AiStoryResponse;
import com.aivle.cultureapp.dto.StoryGenerateRequest;
import com.aivle.cultureapp.dto.StoryResponse;
import com.aivle.cultureapp.entity.Story;
import com.aivle.cultureapp.entity.TimelineEntry;
import com.aivle.cultureapp.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class StoryGenerateService {

    private final RestTemplate restTemplate;
    private final StoryRepository storyRepository;
    private final CategoryImageService categoryImageService;
    private final KakaoAddressService kakaoAddressService;

    @Value("${ai.service.base-url}")
    private String aiServiceBaseUrl;

    public StoryResponse generate(StoryGenerateRequest request) {

        String requestUrl = aiServiceBaseUrl + "/generate";

        Map<String, String> requestBody = Map.of(
                "age", request.age(),
                "mood", request.mood(),
                "purpose", request.purpose(),
                "interest", request.interest()
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<AiStoryResponse> response = restTemplate.exchange(
                requestUrl,
                HttpMethod.POST,
                entity,
                AiStoryResponse.class
        );

        AiStoryResponse aiStory = response.getBody();

        double[] coords = kakaoAddressService.getCoordinates(aiStory.region());
        double lat = coords[0];
        double lng = coords[1];

        String color = categoryImageService.resolveColor(aiStory.category());
        String imageUrl = categoryImageService.resolveImageUrl(aiStory.category());

        Story story = new Story(
                aiStory.title(),
                aiStory.description(),
                aiStory.category(),
                color,
                imageUrl,
                lat,
                lng,
                aiStory.region()
        );

        if (aiStory.timeline() != null) {
            for (StoryResponse.TimelineItem item : aiStory.timeline()) {
                story.addTimeline(new TimelineEntry(item.year(), item.title(), item.text(), story));
            }
        }

        storyRepository.save(story);

        return new StoryResponse(
                story.getId(),
                story.getTitle(),
                story.getDescription(),
                story.getCategory(),
                story.getColor(),
                story.getImageUrl(),
                story.getLat(),
                story.getLng(),
                story.getRegion(),
                aiStory.timeline()
        );
    }
}