package com.aivle.cultureapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record KakaoGeocodeResponse(
        List<Document> documents
) {
    public record Document(
            @JsonProperty("region_type") String regionType,
            @JsonProperty("region_1depth_name") String region1depthName,
            @JsonProperty("region_2depth_name") String region2depthName,
            @JsonProperty("region_3depth_name") String region3depthName
    ) {
    }
}