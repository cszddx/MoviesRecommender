package com.analysis.movie.util.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.analysis.movie.util.Utilities;

public class UtilitiesTest {
    private final static double DELTA = 0.000000001;

    @Test
    public void testGetDoubleSumValueWithEmptyCollections() {
        List<Double> list = new ArrayList<>();

        double sum = Utilities.getDoubleSumValue(list);
        Assert.assertEquals(0, sum, DELTA);
    }

    @Test
    public void testGetDoubleSumValueWithIntegers() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        double sum = Utilities.getDoubleSumValue(list);

        Assert.assertEquals(6.0, sum, DELTA);
    }

    @Test
    public void testGetDoubleSumValueWithDoubles() {
        List<Double> list = new ArrayList<>();
        list.add(1 / 3.0);
        list.add(1 / 3.0);

        double sum = Utilities.getDoubleSumValue(list);
        Assert.assertEquals(2 / 3.0, sum, DELTA);
    }
}
