package com.aivle.cultureapp.service;

import com.aivle.cultureapp.entity.CategoryImage;
import com.aivle.cultureapp.repository.CategoryImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CategoryImageService {

    private final CategoryImageRepository categoryImageRepository;
    private final Random random = new Random();

    public String resolveColor(String category) {
        return switch (category) {
            case "문화재" -> "#3b82f6";
            case "축제" -> "#a855f7";
            case "전통시장" -> "#f97316";
            case "특화거리" -> "#ec4899";
            default -> "#64748b";
        };
    }

    public String resolveImageUrl(String category) {
        List<CategoryImage> images = categoryImageRepository.findByCategory(category);

        if (images.isEmpty()) {
            images = categoryImageRepository.findByCategory("기타");
        }

        if (images.isEmpty()) {
            return "https://images.unsplash.com/photo-1469854523086-cc02fe5d8800?w=800";
        }

        return images.get(random.nextInt(images.size())).getImageUrl();
    }
}