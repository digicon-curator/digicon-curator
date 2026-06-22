package com.aivle.cultureapp.repository;

import com.aivle.cultureapp.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Long> {

    List<Story> findByRegionContaining(String region);
}