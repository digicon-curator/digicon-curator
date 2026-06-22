package com.aivle.cultureapp.controller;

import com.aivle.cultureapp.dto.RegionInfo;
import com.aivle.cultureapp.dto.StoryGenerateRequest;
import com.aivle.cultureapp.dto.StoryResponse;
import com.aivle.cultureapp.service.KakaoGeocodingService;
import com.aivle.cultureapp.service.StoryGenerateService;
import com.aivle.cultureapp.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stories")
@RequiredArgsConstructor
public class StoryController {

    private final StoryService storyService;
    private final KakaoGeocodingService geocodingService;
    private final StoryGenerateService storyGenerateService;

    @GetMapping
    public List<StoryResponse> getAllStories() {
        return storyService.getAllStories();
    }

    @GetMapping("/{id}")
    public StoryResponse getStory(@PathVariable Long id) {
        return storyService.getStoryById(id);
    }

    @GetMapping("/region")
    public List<StoryResponse> getStoriesByCoord(
            @RequestParam double lat,
            @RequestParam double lng
    ) {
        RegionInfo region = geocodingService.getRegion(lat, lng);
        return storyService.getStoriesByRegion(region.city());
    }

    @PostMapping("/generate")
    public StoryResponse generateStory(@RequestBody StoryGenerateRequest request) {
        return storyGenerateService.generate(request);
    }
}