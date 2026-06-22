package com.aivle.cultureapp.dto;

import java.util.List;

public record StoryResponse(
        Long id,
        String title,
        String description,
        String category,
        String color,
        String imageUrl,
        double lat,
        double lng,
        String region,
        List<TimelineItem> timeline
) {
    public record TimelineItem(String year, String title, String text) {
    }
}