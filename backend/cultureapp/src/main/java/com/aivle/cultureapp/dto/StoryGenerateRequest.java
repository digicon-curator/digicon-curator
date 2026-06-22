package com.aivle.cultureapp.dto;

public record StoryGenerateRequest(
        String age,
        String mood,
        String purpose,
        String interest
) {
}