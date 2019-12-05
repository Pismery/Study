package com.pismery.study.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderUtils {
    
    @SafeVarargs
    public static <T> void orderBy(List<T> list, Comparator<T>... comparators) {
        if (comparators == null) {
            throw new IllegalArgumentException("No comparator!...");
        }
        
        Comparator<T> combineComparator = null;
        for (int i = 0; i < comparators.length; i++) {
            if (i == 0) {
                combineComparator = comparators[0];
                continue;
            }
            combineComparator = combineComparator.thenComparing(comparators[i]);
        }
        list.sort(combineComparator);
    }
    
    
}
