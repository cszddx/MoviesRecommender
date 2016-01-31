package com.analysis.movie.similarity.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.analysis.movie.similarity.api.SimilarityComputer;

@Component
public class DistanceSimilarity implements SimilarityComputer {

    @Override
    public double computeSimilarity(Map<Long, Double> map1, Map<Long, Double> map2) {
        Set<Long> sharedMovies = new HashSet<>(map1.keySet());
        sharedMovies.retainAll(map2.keySet());

        if (sharedMovies.size() == 0) {
            return 0;
        }

        double sumOfSquares = 0;
        for (Long id : sharedMovies) {
            sumOfSquares += Math.pow(map1.get(id) - map2.get(id), 2);
        }

        return 1 / (1 + Math.sqrt(sumOfSquares));
    }

}
