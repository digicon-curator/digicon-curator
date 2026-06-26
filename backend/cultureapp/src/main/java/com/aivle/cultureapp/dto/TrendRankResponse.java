package com.aivle.cultureapp.dto;

public record TrendRankResponse(
        Integer rank,
        String title,
        Double trendScore
) {
}