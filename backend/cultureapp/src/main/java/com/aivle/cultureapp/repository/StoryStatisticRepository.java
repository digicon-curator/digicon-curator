package com.aivle.cultureapp.repository;

import com.aivle.cultureapp.entity.StoryStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoryStatisticRepository
        extends JpaRepository<StoryStatistic, Long> {

    Optional<StoryStatistic> findByStoryId(Long storyId);
    List<StoryStatistic> findTop10ByOrderByTrendScoreDesc();
}