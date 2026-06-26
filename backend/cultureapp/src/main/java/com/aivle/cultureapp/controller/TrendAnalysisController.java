package com.aivle.cultureapp.controller;

import com.aivle.cultureapp.dto.TrendAnalysisRequest;
import com.aivle.cultureapp.dto.TrendAnalysisResponse;
import com.aivle.cultureapp.service.TrendAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trends")
@RequiredArgsConstructor
public class TrendAnalysisController {

    private final TrendAnalysisService trendAnalysisService;

    @PostMapping("/analyze")
    public TrendAnalysisResponse analyze(
            @RequestBody TrendAnalysisRequest request
    ) {
        return trendAnalysisService.analyze(request);
    }
}
