package com.aivle.cultureapp.service;

import com.fasterxml.jackson.annotation.JsonProperty;
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

@Service
@RequiredArgsConstructor
public class KakaoAddressService {

    private final RestTemplate restTemplate;

    @Value("${kakao.api.key}")
    private String apiKey;

    @Value("${kakao.api.address-url}")
    private String addressUrl;

    public double[] getCoordinates(String region) {
        URI uri = UriComponentsBuilder.fromUriString(addressUrl)
                .queryParam("query", region)
                .build()
                .encode()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + apiKey);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<KakaoAddressResponse> response = restTemplate.exchange(
                uri, HttpMethod.GET, entity, KakaoAddressResponse.class
        );

        if (response.getBody() == null || response.getBody().documents().isEmpty()) {
            return new double[]{0.0, 0.0};
        }

        KakaoAddressResponse.Document doc = response.getBody().documents().get(0);
        return new double[]{
                Double.parseDouble(doc.y()),
                Double.parseDouble(doc.x())
        };
    }

    public record KakaoAddressResponse(List<Document> documents) {
        public record Document(
                @JsonProperty("address_name") String addressName,
                String x,
                String y
        ) {}
    }
}