package com.analysis.movie.similarity.impl.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.analysis.movie.similarity.api.SimilarityComputer;
import com.analysis.movie.similarity.impl.PearsonSimilarity;

public class PearsonSimilarityTest {
    private SimilarityComputer similarity;
    private static final double DELTA = 0000001;

    @Before
    public void setUp() throws Exception {
        similarity = new PearsonSimilarity();
    }

    @After
    public void tearDown() throws Exception {
        similarity = null;
    }

    @Test
    public void testEmptyData() {
        Map<Long, Double> map1 = new HashMap<Long, Double>();

        Map<Long, Double> map2 = new HashMap<Long, Double>();
        map2.put(4L, 2.0);
        map2.put(5L, 3.0);
        map2.put(6L, 3.5);

        double result = similarity.computeSimilarity(map1, map2);
        Assert.assertEquals(0.0, result, DELTA);
    }

    @Test
    public void testNoRelationship() {
        Map<Long, Double> map1 = new HashMap<Long, Double>();
        map1.put(1L, 1.0);
        map1.put(2L, 3.0);
        map1.put(3L, 5.0);

        Map<Long, Double> map2 = new HashMap<Long, Double>();
        map2.put(4L, 2.0);
        map2.put(5L, 3.0);
        map2.put(6L, 3.5);

        double result = similarity.computeSimilarity(map1, map2);
        Assert.assertEquals(0.0, result, DELTA);
    }

    @Test
    public void testTheSameData() {
        Map<Long, Double> map1 = new HashMap<Long, Double>();
        map1.put(1L, 1.0);
        map1.put(2L, 3.0);
        map1.put(3L, 5.0);

        Map<Long, Double> map2 = new HashMap<Long, Double>();
        map2.put(1L, 1.0);
        map2.put(2L, 3.0);
        map2.put(3L, 5.0);

        double result = similarity.computeSimilarity(map1, map2);
        Assert.assertEquals(1.0, result, DELTA);
    }

    @Test
    public void testPositiveRelationship() {
        Map<Long, Double> map1 = new HashMap<Long, Double>();
        map1.put(1L, 1.0);
        map1.put(2L, 2.0);
        map1.put(3L, 3.0);
        map1.put(4L, 4.0);
        map1.put(5L, 5.0);

        Map<Long, Double> map2 = new HashMap<Long, Double>();
        map2.put(1L, 2.0);
        map2.put(2L, 3.0);
        map2.put(4L, 4.0);
        map2.put(5L, 5.0);
        map2.put(6L, 3.8);

        double result = similarity.computeSimilarity(map1, map2);

        Assert.assertTrue(result > 0.95);
    }

    @Test
    public void testNegativeRelationship() {
        Map<Long, Double> map1 = new HashMap<Long, Double>();
        map1.put(1L, 1.0);
        map1.put(2L, 2.0);
        map1.put(3L, 3.0);
        map1.put(4L, 4.0);
        map1.put(5L, 5.0);

        Map<Long, Double> map2 = new HashMap<Long, Double>();
        map2.put(1L, 5.0);
        map2.put(2L, 4.0);
        map2.put(4L, 3.0);
        map2.put(5L, 2.0);
        map2.put(6L, 3.8);

        double result = similarity.computeSimilarity(map1, map2);

        Assert.assertTrue(result < -0.95);
    }
}
