package com.aivle.cultureapp.dto;

import java.util.Set;

public record RegionInfo(
        String province,
        String city
) {
    private static final Set<String> METROPOLITAN_CITIES = Set.of(
            "서울특별시", "부산광역시", "대구광역시", "인천광역시",
            "광주광역시", "대전광역시", "울산광역시", "세종특별자치시"
    );

    public String cityNameOnly() {
        if (city == null) return "";
        if (METROPOLITAN_CITIES.contains(city)) return city;
        return city.replaceAll("(시|군|구)$", "");
    }
}