package com.aivle.cultureapp.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StoryResponse {

    private Long id;

    private String title;

    private String desc;

    private String category;

    private Double lat;

    private Double lng;

    private String color;

    private String imageUrl;
}