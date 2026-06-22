package com.aivle.cultureapp.repository;

import com.aivle.cultureapp.entity.CategoryImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryImageRepository extends JpaRepository<CategoryImage, Long> {

    List<CategoryImage> findByCategory(String category);
}