package com.aivle.cultureapp.repository;

import com.aivle.cultureapp.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository
        extends JpaRepository<Story, Long> {
}