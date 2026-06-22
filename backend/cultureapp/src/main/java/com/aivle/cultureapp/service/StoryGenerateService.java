package com.aivle.cultureapp.service;

import com.aivle.cultureapp.dto.AiStoryResponse;
import com.aivle.cultureapp.dto.StoryGenerateRequest;
import com.aivle.cultureapp.dto.StoryResponse;
import com.aivle.cultureapp.entity.Story;
import com.aivle.cultureapp.entity.TimelineEntry;
import com.aivle.cultureapp.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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

        ResponseEntity<AiStoryResponse> response = restTemplate.postForEntity(
                requestUrl, requestBody, AiStoryResponse.class
        );

        AiStoryResponse aiStory = response.getBody();

        // TODO: 카카오 address search API로 지역명→좌표 변환 구현 필요 (회의 후 결정)
        double lat = 0.0;
        double lng = 0.0;

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
                TimelineEntry entry = new TimelineEntry(
                        item.year(), item.title(), item.text(), story
                );
                story.addTimeline(entry);
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