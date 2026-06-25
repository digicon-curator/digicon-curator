package com.aivle.cultureapp.controller;

import com.aivle.cultureapp.dto.MapStoryResponse;
import com.aivle.cultureapp.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/map")
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;

    @GetMapping("/stories")
    public List<MapStoryResponse> getStories() {
        return mapService.getMapStories();
    }
}