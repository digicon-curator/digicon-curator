package com.aivle.cultureapp.service;

import com.aivle.cultureapp.dto.TrendAnalysisRequest;
import com.aivle.cultureapp.dto.TrendAnalysisResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TrendAnalysisService {

    private final RestTemplate restTemplate;

    @Value("${ai.service.base-url}")
    private String aiServiceBaseUrl;

    public TrendAnalysisResponse analyze(
            TrendAnalysisRequest request
    ) {

        String url =
                aiServiceBaseUrl + "/trend-analyze";

        ResponseEntity<TrendAnalysisResponse> response =
                restTemplate.postForEntity(
                        url,
                        request,
                        TrendAnalysisResponse.class
                );

        return response.getBody();
    }
}