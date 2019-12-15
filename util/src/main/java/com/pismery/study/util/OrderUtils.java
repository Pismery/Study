package com.pismery.study.util;

import java.util.Comparator;
import java.util.List;

public class OrderUtils {
    @SafeVarargs
    public static <T> void orderBy(List<T> list, Comparator<T>... comparators) {
        if (comparators == null || comparators.length == 0) {
            throw new IllegalArgumentException("No comparator!...");
        }

        Comparator<T> combineComparator = comparators[0];
        for (int i = 1; i < comparators.length; i++) {
            combineComparator = combineComparator.thenComparing(comparators[i]);
        }
        list.sort(combineComparator);
    }
}
