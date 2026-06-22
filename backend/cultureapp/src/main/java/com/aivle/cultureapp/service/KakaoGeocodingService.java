package com.aivle.cultureapp.service;

import com.aivle.cultureapp.dto.KakaoGeocodeResponse;
import com.aivle.cultureapp.dto.RegionInfo;
import com.aivle.cultureapp.exception.RegionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class KakaoGeocodingService {

    private final RestTemplate restTemplate;

    @Value("${kakao.api.key}")
    private String apiKey;

    @Value("${kakao.api.geocode-url}")
    private String geocodeUrl;

    private static final Set<String> METROPOLITAN_CITIES = Set.of(
            "서울특별시", "부산광역시", "대구광역시", "인천광역시",
            "광주광역시", "대전광역시", "울산광역시", "세종특별자치시"
    );

    public RegionInfo getRegion(double lat, double lng) {

        URI uri = UriComponentsBuilder.fromUriString(geocodeUrl)
                .queryParam("x", lng)
                .queryParam("y", lat)
                .build()
                .encode()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + apiKey);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<KakaoGeocodeResponse> response = restTemplate.exchange(
                uri, HttpMethod.GET, entity, KakaoGeocodeResponse.class
        );

        List<KakaoGeocodeResponse.Document> documents =
                response.getBody() != null ? response.getBody().documents() : null;

        if (documents == null || documents.isEmpty()) {
            throw new RegionNotFoundException("해당 좌표의 행정구역을 찾을 수 없습니다.");
        }

        KakaoGeocodeResponse.Document doc = documents.stream()
                .filter(d -> "H".equals(d.regionType()))
                .findFirst()
                .orElse(documents.get(0));

        String province = doc.region1depthName();
        String cityName = resolveCityName(province, doc.region2depthName());

        return new RegionInfo(province, cityName);
    }

    private String resolveCityName(String province, String region2depthName) {
        if (METROPOLITAN_CITIES.contains(province)) {
            return province;
        }
        if (region2depthName == null) {
            return "";
        }
        String[] parts = region2depthName.split(" ");
        return parts[0];
    }
}