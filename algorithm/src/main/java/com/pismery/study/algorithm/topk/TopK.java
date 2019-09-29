package com.pismery.study.algorithm.topk;

import java.util.Arrays;

public class TopK {
    public static int versionOne(int[] sources, int k) {
        if (k > sources.length)
            throw new RuntimeException();

        Arrays.sort(sources);
        return sources[sources.length - k];
    }

    public static int versionTwo(int[] sources, int k) {
        if (k > sources.length)
            throw new RuntimeException();

        bubbingSort(sources, k);
        return sources[sources.length - k];
    }

    private static void bubbingSort(int[] sources, int round) {
        int temp;
        for (int i = 1; i <= round; i++) {
            for (int j = 0; j < sources.length - i; j++) {
                if (sources[j] <= sources[j + 1])
                    continue;

                temp = sources[j];
                sources[j] = sources[j + 1];
                sources[j + 1] = temp;
            }
        }
    }
}
