package com.aivle.cultureapp.service;

import com.aivle.cultureapp.dto.MapStoryResponse;
import com.aivle.cultureapp.entity.Story;
import com.aivle.cultureapp.entity.StoryStatistic;
import com.aivle.cultureapp.repository.StoryRepository;
import com.aivle.cultureapp.repository.StoryStatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MapService {

    private final StoryRepository storyRepository;
    private final StoryStatisticRepository storyStatisticRepository;

    public List<MapStoryResponse> getMapStories() {

        return storyRepository.findAll()
                .stream()
                .map(this::toMapResponse)
                .toList();
    }

    private MapStoryResponse toMapResponse(Story story) {

        StoryStatistic statistic = storyStatisticRepository.findByStoryId(story.getId()).orElse(null);

        double trendScore = 0.0;
        String summary = "";

        if (statistic != null) {
            trendScore = statistic.getTrendScore();
            summary = statistic.getSummary();
        }

        return new MapStoryResponse(
                story.getId(),
                story.getTitle(),
                story.getCategory(),
                story.getLat(),
                story.getLng(),
                trendScore,
                summary
        );
    }
}