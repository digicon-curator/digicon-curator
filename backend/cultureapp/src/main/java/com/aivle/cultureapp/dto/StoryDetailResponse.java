package com.aivle.cultureapp.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StoryDetailResponse {

    private Long id;

    private String title;

    private String desc;

    private String category;

    private Double lat;

    private Double lng;

    private String color;

    private String imageUrl;

    private List<TimelineResponse> timelines;
}