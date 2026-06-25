package com.aivle.cultureapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class StoryStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "story_id", unique = true)
    private Story story;

    private Integer searchCount;
    private Integer visitCount;
    private Integer reviewCount;
    private Double satisfaction;
    private Double trendScore;

    @Column(length = 500)
    private String summary;


    public StoryStatistic(
        Story story,
        Integer searchCount,
        Integer visitCount,
        Integer reviewCount,
        Double satisfaction,
        Double trendScore,
        String summary
) {
    this.story = story;
    this.searchCount = searchCount;
    this.visitCount = visitCount;
    this.reviewCount = reviewCount;
    this.satisfaction = satisfaction;
    this.trendScore = trendScore;
    this.summary = summary;
}
}

