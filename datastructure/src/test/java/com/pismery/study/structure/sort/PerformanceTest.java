package com.pismery.study.structure.sort;

import com.pismery.study.util.RandomUtils;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by pismery on 2018-06-09.
 */
public class PerformanceTest {

    private static final int SOURCE_SIZE = 1000000;
    private static final int PRECISION = 10000;
    private static final DecimalFormat df = new DecimalFormat("#.0000");


    @Test
    public void performance_nearly_sorted() {
        System.out.println("performance_nearly_sorted: arraySize = " + SOURCE_SIZE);
        int[] source1 = RandomUtils.randomArrayNearlySorted(SOURCE_SIZE, 10);
        sort(source1);
    }

    @Test
    public void performance_totally_random() {
        System.out.println("performance_totally_random: arraySize = " + SOURCE_SIZE);
        int[] source1 = RandomUtils.randomArray(1, 2000, SOURCE_SIZE);
        sort(source1);
    }

    @Test
    public void performance_many_repeat_array() {
        System.out.println("performance_many_repeat_array: arraySize = " + SOURCE_SIZE);
        int[] source1 = RandomUtils.randomArray(1, 10, SOURCE_SIZE);
        sort(source1);
    }



    private void sort(int[] source) {

        //bubbingSort(source);
        //selectSort(source);
        //insertSort(source);
        //quickSort(source);
        //mergeSort(source);
        //shellSort(source);
        //heapSort(source);
        countSort(source);
        bucketSort(source);
        radixSort(source);
        System.out.println();

    }

    public void radixSort(int[] source) {
        int[] radixSortLSD = Arrays.copyOf(source, source.length);
        int[] radixSortMSD = Arrays.copyOf(source, source.length);
        Date startTime = new Date();
        Date endTime = new Date();
        double costTime = 0.0;

        startTime = new Date();
        RadixSort.radixSortLSD(radixSortLSD);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("RadixSortLSD time:", costTime);

        startTime = new Date();
        RadixSort.radixSortMSD(radixSortMSD);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("RadixSortMSD time:", costTime);
    }

    public void bucketSort(int[] source) {
        int[] bucketSort = Arrays.copyOf(source, source.length);
        int[] bucketSort2 = Arrays.copyOf(source, source.length);
        Date startTime = new Date();
        Date endTime = new Date();
        double costTime = 0.0;

        startTime = new Date();
        BucketSort.bucketSort(bucketSort);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("BucketSort time:", costTime);

        startTime = new Date();
        BucketSort.bucketSort2(bucketSort2);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("BucketSort2 time:", costTime);
    }

    public void heapSort(int[] source) {
        int[] heapSort = Arrays.copyOf(source, source.length);
        int[] heapSort1 = Arrays.copyOf(source, source.length);
        int[] heapSort2 = Arrays.copyOf(source, source.length);
        Date startTime = new Date();
        Date endTime = new Date();
        double costTime = 0.0;

        startTime = new Date();
        HeapSort.heapSort(heapSort);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("HeapSort time:", costTime);

        startTime = new Date();
        HeapSort.heapSort1(heapSort1);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("HeapSort1 time:", costTime);

        startTime = new Date();
        HeapSort.heapSort2(heapSort2);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("HeapSort2 time:", costTime);
    }

    public void shellSort(int[] source) {
        int[] shellSort = Arrays.copyOf(source, source.length);
        int[] shellSortOptimization = Arrays.copyOf(source, source.length);
        Date startTime = new Date();
        Date endTime = new Date();
        double costTime = 0.0;

        startTime = new Date();
        ShellSort.shellSort(shellSort);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("ShellSort time:", costTime);

        startTime = new Date();
        ShellSort.shellSortOptimization(shellSortOptimization);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("ShellSortOptimization time:", costTime);

    }

    public void mergeSort(int[] source) {
        int[] mergeSortNormal = Arrays.copyOf(source, source.length);
        int[] mergeSortFromBottomToUp = Arrays.copyOf(source, source.length);
        int[] mergeSortThreeWay = Arrays.copyOf(source, source.length);
        Date startTime = new Date();
        Date endTime = new Date();
        double costTime = 0.0;

        startTime = new Date();
        MergeSort.mergeSortNormal(mergeSortNormal);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("MergeSortNormal time:", costTime);

        startTime = new Date();
        MergeSort.mergeSortFromBottomToUp(mergeSortNormal);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("MergeSortFromBottomToUp time:", costTime);

        startTime = new Date();
        MergeSort.mergeSortThreeWay(mergeSortNormal);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("MergeSortThreeWay time:", costTime);
    }

    private void countSort(int[] source) {
        int[] countSortWithMap = Arrays.copyOf(source, source.length);
        Date startTime = new Date();
        Date endTime = new Date();
        double costTime = 0.0;

        startTime = new Date();
        CountSort.countSortWithMap(countSortWithMap);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("CountSortWithMap time:", costTime);

        startTime = new Date();
        CountSort.countSort(countSortWithMap);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("CountSort time:", costTime);
    }

    private void quickSort(int[] source) {
        int[] quickSortRecursion = Arrays.copyOf(source, source.length);
        int[] quickSortNoRecursion = Arrays.copyOf(source, source.length);
        int[] quickSortRecursionVersion2 = Arrays.copyOf(source, source.length);
        int[] quickSortNoRecursionVersion2 = Arrays.copyOf(source, source.length);
        int[] quickSortThreeWay = Arrays.copyOf(source, source.length);

        Date startTime = new Date();
        Date endTime = new Date();
        double costTime = 0.0;

        startTime = new Date();
        QuickSort.quickSortRecursion(quickSortRecursion, 0, quickSortNoRecursion.length - 1);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("QuickSortRecursion time:", costTime);

        startTime = new Date();
        QuickSort.quickSortNoRecursion(quickSortNoRecursion);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("QuickSortNoRecursion time:", costTime);

        startTime = new Date();
        QuickSort.quickSortRecursionVersion2(quickSortRecursionVersion2, 0, quickSortRecursionVersion2.length - 1);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("QuickSortRecursionVersion2 time:", costTime);

        startTime = new Date();
        QuickSort.quickSortNoRecursionVersion2(quickSortNoRecursionVersion2);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("QuickSortNoRecursionVersion2 time:", costTime);

        startTime = new Date();
        QuickSort.quickSortThreeWay(quickSortThreeWay, 0, quickSortThreeWay.length - 1);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("QuickSortThreeWay time:", costTime);
    }

    private void insertSort(int[] source) {
        Date startTime = new Date();
        Date endTime = new Date();
        double costTime = 0.0;

        int[] insertionSortNormal = Arrays.copyOf(source, source.length);
        int[] insertionSortOptimization = Arrays.copyOf(source, source.length);
        int[] insertionSortWithDichotomy = Arrays.copyOf(source, source.length);

        startTime = new Date();
        InsertionSort.insertionSortNormal(insertionSortNormal);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("InsertionSortNormal time:", costTime);

        startTime = new Date();
        InsertionSort.insertionSortOptimization(insertionSortOptimization);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("InsertionSortOptimization time:", costTime);

        startTime = new Date();
        InsertionSort.insertionSortWithDichotomy(insertionSortWithDichotomy);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("InsertionSortWithDichotomy time:", costTime);
    }

    private void selectSort(int[] source) {
        int[] selectSort = Arrays.copyOf(source, source.length);

        Date startTime = new Date();
        Date endTime = new Date();
        double costTime = 0.0;

        startTime = new Date();
        SelectSort.SelectSort(selectSort);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("SelectSort time:", costTime);


    }

    private void bubbingSort(int[] source) {
        int[] bubbingSortNormal = Arrays.copyOf(source, source.length);
        int[] bubbingSortOptimization = Arrays.copyOf(source, source.length);
        int[] bubbingSortMax = Arrays.copyOf(source, source.length);
        int[] bubbingSortBidirectional = Arrays.copyOf(source, source.length);

        Date startTime = new Date();
        Date endTime = new Date();
        double costTime = 0.0;

        startTime = new Date();
        BubbingSort.bubbingSortNormal(bubbingSortNormal);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("BubbingSortNormal time:", costTime);

        startTime = new Date();
        BubbingSort.bubbingSortOptimization(bubbingSortOptimization);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("BubbingSortOptimization time:", costTime);

        startTime = new Date();
        BubbingSort.bubbingSortByExchangeIndex(bubbingSortMax);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("BubbingSortByExchangeIndex time:", costTime);

        startTime = new Date();
        BubbingSort.bubbingSortBidirectional(bubbingSortBidirectional);
        endTime = new Date();
        costTime = (double) (endTime.getTime() - startTime.getTime()) / PRECISION;
        printTime("BubbingSortBidirectional time:", costTime);
    }


    private void printTime(String name, double costTime) {
        System.out.println(name + " " + df.format(costTime) + " s");
    }
}
