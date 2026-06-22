package com.aivle.cultureapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String category;
    private String color;
    private String imageUrl;
    private double lat;
    private double lng;
    private String region;

    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimelineEntry> timeline = new ArrayList<>();

    public Story(String title, String description, String category,
                 String color, String imageUrl, double lat, double lng, String region) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.color = color;
        this.imageUrl = imageUrl;
        this.lat = lat;
        this.lng = lng;
        this.region = region;
    }

    public void addTimeline(TimelineEntry entry) {
        this.timeline.add(entry);
    }
}