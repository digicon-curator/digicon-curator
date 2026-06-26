package com.aivle.cultureapp.service;

import com.aivle.cultureapp.dto.TrendRankResponse;
import com.aivle.cultureapp.entity.StoryStatistic;
import com.aivle.cultureapp.repository.StoryStatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrendRankingService {

    private final StoryStatisticRepository storyStatisticRepository;

    public List<TrendRankResponse> getTop10() {

        List<StoryStatistic> statistics =
                storyStatisticRepository.findTop10ByOrderByTrendScoreDesc();

        List<TrendRankResponse> result = new ArrayList<>();

        for (int i = 0; i < statistics.size(); i++) {

            StoryStatistic stat = statistics.get(i);

            result.add(
                    new TrendRankResponse(
                            i + 1,
                            stat.getStory().getTitle(),
                            stat.getTrendScore()
                    )
            );
        }

        return result;
    }
}