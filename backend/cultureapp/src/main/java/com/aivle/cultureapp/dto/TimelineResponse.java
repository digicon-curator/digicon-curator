package com.aivle.cultureapp.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TimelineResponse {

    private String year;

    private String title;

    private String text;
}