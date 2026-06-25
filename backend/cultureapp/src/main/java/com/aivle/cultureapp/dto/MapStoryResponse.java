package com.aivle.cultureapp.dto;

public record MapStoryResponse(
        Long id,
        String title,
        String category,
        double lat,
        double lng,
        double trendScore,
        String summary
) {
}
