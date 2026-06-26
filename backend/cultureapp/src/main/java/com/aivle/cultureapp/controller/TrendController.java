package com.aivle.cultureapp.controller;

import com.aivle.cultureapp.dto.TrendRankResponse;
import com.aivle.cultureapp.service.TrendRankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trends")
@RequiredArgsConstructor
public class TrendController {

    private final TrendRankingService trendRankingService;

    @GetMapping("/top")
    public List<TrendRankResponse> getTop10() {
        return trendRankingService.getTop10();
    }
}