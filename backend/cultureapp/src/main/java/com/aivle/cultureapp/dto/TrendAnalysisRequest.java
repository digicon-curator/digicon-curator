package com.aivle.cultureapp.dto;

public record TrendAnalysisRequest(
        Integer searchCount,
        Integer visitCount,
        Integer reviewCount,
        Double satisfaction
) {
}
