package com.analysis.movie.similarity.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.analysis.movie.similarity.api.SimilarityComputer;
import com.analysis.movie.util.Utilities;

/**
 * This class is the implementation of Pearson Correlation Coefficient, referring to the article I found:
 * http://blog.csdn.net/wenbingoon/article/details/17414063 . For simplicity and time limitation, I just implement the
 * user-item based algorithm. Although in this case it's somehow better than item-item algorithm, it's not without its
 * defects. In reality, it's not uncommon to combine loads of algorithms together to get precise results.
 *
 * @author duxin
 *
 */
@Component
public class PearsonSimilarity implements SimilarityComputer {
    /**
     * Get the similarity of 2 users based on ratings to the movies they have seen
     *
     * @param map1
     *            , stores the movie id and corresponding rating by one user
     * @param map2
     *            , stores the movie id and corresponding rating by another user
     * @return
     */
    @Override
    public double computeSimilarity(Map<Long, Double> map1, Map<Long, Double> map2) {
        if (Utilities.isNullOrEmpty(map1) || Utilities.isNullOrEmpty(map2)) {
            return 0;
        }
        // get shared items between specified users
        final Set<Long> sharedItems = new HashSet<>(map1.keySet());
        sharedItems.retainAll(map2.keySet());

        final int sharedSize = sharedItems.size();
        if (sharedSize == 0) {
            return 0;
        }

        double sumX = 0, sumY = 0, sumSqrtX = 0, sumSqrtY = 0, sumMulti = 0;
        for (long item : sharedItems) {
            double x = map1.get(item);
            double y = map2.get(item);
            sumX += x;
            sumY += y;
            sumSqrtX += Math.pow(x, 2);
            sumSqrtY += Math.pow(y, 2);
            sumMulti += x * y;
        }

        final double numerator = sumMulti - (sumX * sumY) / sharedSize;
        final double denominator = Math.sqrt(sumSqrtX - Math.pow(sumX, 2) / sharedSize)
                * Math.sqrt(sumSqrtY - Math.pow(sumY, 2) / sharedSize);
        if (Double.compare(denominator, 0) == 0) {
            return 0;
        }

        return numerator / denominator;
    }

}
