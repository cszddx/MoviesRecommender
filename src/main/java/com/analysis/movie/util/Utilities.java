package com.analysis.movie.util;

import java.util.Collection;
import java.util.Map;

public class Utilities {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.equals("");
    }

    public static boolean isNullOrEmpty(Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNullOrEmpty(Map<?, ?> map) {
        return map == null || map.keySet().size() == 0;
    }

    public static double getDoubleSumValue(Collection<? extends Number> coll) {
        double sum = 0;
        for (Number num : coll) {
            sum += num.doubleValue();
        }

        return sum;
    }
}
