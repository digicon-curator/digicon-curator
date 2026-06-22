package com.aivle.cultureapp.dto;

import java.util.List;

public record AiStoryResponse(
        String title,
        String description,
        String category,
        String region,
        List<StoryResponse.TimelineItem> timeline
) {
}