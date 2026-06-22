package com.aivle.cultureapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class TimelineEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String year;
    private String title;

    @Column(length = 1000)
    private String text;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;

    public TimelineEntry(String year, String title, String text, Story story) {
        this.year = year;
        this.title = title;
        this.text = text;
        this.story = story;
    }
}