package com.aivle.cultureapp.service;

import com.aivle.cultureapp.dto.StoryResponse;
import com.aivle.cultureapp.entity.Story;
import com.aivle.cultureapp.exception.RegionNotFoundException;
import com.aivle.cultureapp.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoryService {

    private final StoryRepository storyRepository;

    public List<StoryResponse> getAllStories() {
        return storyRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public StoryResponse getStoryById(Long id) {
        Story story = storyRepository.findById(id)
                .orElseThrow(() -> new RegionNotFoundException("해당 스토리를 찾을 수 없습니다."));
        return toResponse(story);
    }

    public List<StoryResponse> getStoriesByRegion(String region) {
        return storyRepository.findByRegionContaining(region).stream()
                .map(this::toResponse)
                .toList();
    }

    private StoryResponse toResponse(Story story) {
        List<StoryResponse.TimelineItem> timelineItems = story.getTimeline().stream()
                .map(t -> new StoryResponse.TimelineItem(t.getYear(), t.getTitle(), t.getText()))
                .toList();

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
                timelineItems
        );
    }
}