package com.pismery.study.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by pismery on 2018-07-02.
 */
@Slf4j
public class HeapSort {
    /**
     * 数组索引从0开始，因此
     * 左孩子 = 2 * index + 1;
     * 右孩子 = 2 * index + 2;
     * 父亲 = (index - 1) 2;
     * 第一个父亲节点 = (length -1) /2;
     */
    public static void heapSort(int[] sources) {
        int length = sources.length;
        //heapify
        for (int i = (length - 1) / 2; i >= 0; i--) {
            shiftDown(sources, length, i);
        }

        for (int i = length - 1; i > 0; i--) {
            sources[i] ^= sources[0];
            sources[0] ^= sources[i];
            sources[i] ^= sources[0];

            shiftDown(sources, i, 0); //注意是i 而不是i+1;因为一开始就将最后一位剔除
        }
    }

    private static void shiftDown(int[] arr, int length, int index) {
        while (2 * index + 1 <= length - 1) {
            int changeIndex = 2 * index + 1; //此轮循环，arr[index]与arr[changeIndex]交换

            //如果存在右孩子且大于左孩子
            if (changeIndex + 1 <= length - 1 && arr[changeIndex + 1] > arr[changeIndex])
                changeIndex++;
            //如果父节点比孩子都大
            if (arr[index] >= arr[changeIndex])
                break;

            arr[index] ^= arr[changeIndex];
            arr[changeIndex] ^= arr[index];
            arr[index] ^= arr[changeIndex];

            index = changeIndex;
        }
    }

    private static void exchange(int[] arr, int xIndex, int yIndex) {
        if (xIndex == yIndex)
            return;
        arr[xIndex] ^= arr[yIndex];
        arr[yIndex] ^= arr[xIndex];
        arr[xIndex] ^= arr[yIndex];
    }

    public static void heapSort1(int[] sources) {
        int length = sources.length;
        Heap heap = new Heap(length);
        for (int i = 0; i < length; i++) {
            heap.add(sources[i]);
        }

        for (int i = length - 1; i >= 0; i--) {
            sources[i] = heap.pop();
        }

    }

    public static void heapSort2(int[] sources) {
        int length = sources.length;
        Heap heap = new Heap(sources);

        for (int i = length - 1; i >= 0; i--) {
            sources[i] = heap.pop();
        }

    }


    /**
     * 从1开始赋值 通过数组保存此最大堆。因为是完全二叉树所以可以使用数组保存
     * 左孩子 = 2*index;
     * 右孩子 = 2*index+1;
     * 父亲 = index/2;
     */
    private static class Heap {
        private int[] heap;
        private int capacity; //heap最大容量
        private int length; //heap当前大小


        public Heap(int capacity) {
            this.heap = new int[capacity + 1];
            this.capacity = capacity;
        }

        public Heap(int[] arr) {
            this.capacity = arr.length + 1;
            this.heap = new int[capacity];

            for (int i = 0; i < capacity - 1; i++) {
                heap[i + 1] = arr[i];
            }
            length = arr.length;

            //heapify
            for (int i = length / 2; i > 0; i--) {
                shiftDown(i);
            }

        }

        public void add(int aim) {
            if (length == capacity) {
                capacity *= 2;
                this.heap = Arrays.copyOf(heap, capacity + 1);
            }

            heap[++length] = aim;

            shiftUp(length);
        }

        public int pop() {
            if (isEmpty())
                throw new RuntimeException("Heap is empty");

            int result = heap[1];

            heap[1] = heap[length--];

            shiftDown(1);
            return result;
        }

        public void showHeap() {
            int[] tmp = new int[length];
            for (int i = 0; i < length; i++) {
                tmp[i] = heap[i + 1];
            }

            log.info("Heap :" + Arrays.toString(tmp));
        }

        private void shiftDown(int index) {

            while (2 * index <= length) { //确保左孩子存在
                if (2 * index + 1 <= length) { //如果右孩子存在
                    if (heap[index] >= heap[2 * index] && heap[index] >= heap[2 * index + 1])
                        break;

                    if (heap[2 * index] >= heap[2 * index + 1]) {
                        exchange(index, 2 * index);
                        index *= 2;
                    } else {
                        exchange(index, 2 * index + 1);
                        index = 2 * index + 1;
                    }

                } else { //如果只有左孩子
                    if (heap[index] >= heap[2 * index])
                        break;

                    exchange(index, 2 * index);
                    index *= 2;
                }
            }
        }

        private void shiftUp(int index) {
            while (index / 2 > 0) {
                if (heap[index / 2] >= heap[index])
                    break;

                exchange(index, index / 2);

                index /= 2;
            }
        }

        private boolean isEmpty() {
            if (length <= 0)
                return true;

            return false;
        }

        private void exchange(int xIndex, int yIndex) {
            if (xIndex == yIndex)
                return;
            heap[xIndex] ^= heap[yIndex];
            heap[yIndex] ^= heap[xIndex];
            heap[xIndex] ^= heap[yIndex];
        }
    }


}
