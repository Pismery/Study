package com.pismery.study.structure.sort;

import java.util.Stack;

public class QuickSort {

    private QuickSort() {
        return;
    }

    /**
     * 1.将数组分为三段：小于基准；等于基准；大于基准
     * 2.每次在小于基准和大于基准中循环
     */
    public static void quickSortThreeWay(int[] source, int beginIndex, int endIndex) {
        if (beginIndex >= endIndex) {
            return;
        }

        int ltIndex = beginIndex;//小于基准的最右指针;初始化保证为空
        int gtIndex = endIndex + 1;//大于基准的最左指针;初始化保证为空
        int benchmark = source[beginIndex];
        int currentIndex = beginIndex + 1;

        while (currentIndex < gtIndex) {
            // 注意currentIndex < gtIndex 不能是currentIndex <= gtIndex。
            // 例如调用quickSortThreeWay(source, 4, 5);soure[10,11,12,13,14,15]
            // benginIndex = 4,endIndex = 5,gtIndex = 6,benchmark = 14;
            // 第一轮 source[currentIndex] = 15 > 14执行exchage(source, currentIndex, --gtIndex);
            // gtIndex = 5,currentIndex = 5; 此时因为currentIndex == gtIndex；
            // 因此再次执行了exchage(source, currentIndex, --gtIndex);gtIndex = 4;
            // 再次递归调用了quickSortThreeWay(source, 4, 5); 最终栈溢出；
            if (source[currentIndex] < benchmark) {
                // ltIndex 先++ 后交换。 交换后currntIndex++;
                exchage(source, ++ltIndex, currentIndex++);
            } else if (source[currentIndex] > benchmark) {
                // gtIndex 先-- 后交换。 交换后currntIndex不用++;
                // 因为后面的元素还是未检查的元素;
                exchage(source, currentIndex, --gtIndex);
            } else {
                currentIndex++;
            }
        }
        exchage(source, beginIndex, ltIndex--);
        quickSortThreeWay(source, beginIndex, ltIndex);
        quickSortThreeWay(source, gtIndex, endIndex);

    }

    /**
     * 1.从左往右找到大于基准的索引(left)，从右往左找小于基准的索引(right)
     * 2.交换索引(left)与索引(right)位置
     * 3. 直到left < right
     */
    public static void quickSortRecursion(int[] source, int beginIndex, int endIndex) {
        if (beginIndex >= endIndex) {
            return;
        }

        int standard = source[beginIndex];
        int left = beginIndex;
        int right = endIndex;

        while (left < right) {
            while (source[right] > standard && left < right) { //从右往左找比基准小的索引
                right--;
            }
            while (source[left] <= standard && left < right) { //从左往右找比基准大的索引 必须<= 否则第一个就一直不动
                left++;
            }

            exchage(source, left, right);
        }
        //将基准与最终位置交换；使得左边均小于基准，右边均大于基准
        source[beginIndex] = source[left];
        source[left] = standard;

        quickSortRecursion(source, beginIndex, left - 1);
        quickSortRecursion(source, left + 1, endIndex);
    }

    /**
     * 快速排序非递归方式
     */
    public static void quickSortNoRecursion(int[] source) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(source.length - 1);

        int left;
        int right;
        int benchmark; //基准
        int beginIndex;
        int endIndex;
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();

            if (right == left)
                continue;

            benchmark = source[left];

            beginIndex = left;
            endIndex = right;

            while (left < right) {
                //寻找需要交换的地址
                while (benchmark < source[right] && left < right) {
                    right--;
                }
                while (benchmark >= source[left] && left < right) {
                    left++;
                }
                if (right == left)
                    continue;
                exchage(source, left, right);
            }
            source[beginIndex] = source[left];
            source[left] = benchmark;


            //压栈
            if (endIndex > left) {
                stack.push(left + 1);
                stack.push(endIndex);
            }
            if (beginIndex < left) {
                stack.push(beginIndex);
                stack.push(left - 1);
            }
        }

    }

    public static void quickSortNoRecursionVersion2(int[] source) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        stack.push(source.length - 1);

        int left;
        int right;
        int beginIndex;
        int endIndex;
        boolean flag = true;

        while (!stack.empty()) {
            right = stack.pop();
            left = stack.pop();

            if (left >= right)
                continue;

            beginIndex = left;
            endIndex = right;

            while (left < right) {
                if (flag) { //基准在左边
                    if (source[left] < source[right]) {//右边哨兵大于基准，右哨兵左移;
                        right--;
                        continue;
                    }
                    exchage(source, left, right);
                    left++;
                    flag = false;
                } else { //基准在右边
                    if (source[left] < source[right]) {//左边哨兵小于基准，左哨兵右移;
                        left++;
                        continue;
                    }
                    exchage(source, left, right);
                    right--;
                    flag = true;
                }
            }

            stack.push(left + 1);
            stack.push(endIndex);
            stack.push(beginIndex);
            stack.push(left - 1);
        }


    }

    /**
     * 1. 基准在左边，从右边开始扫描到小于基准值(right--)，交换位置。基准变成右边；
     * 2. 基准在右边，从左边开始扫描到大于基准值(left++)，交换位置。基准变成左边；
     * 3. 直到(left < right)
     */
    public static void quickSortRecursionVersion2(int[] source, int left, int right) {

        if (left >= right) {
            return;
        }

        int begin = left;
        int end = right;

        boolean flag = true; //true:benchmark is left;false:benchmark is right
        while (left < right) {
            //注意不能left==right,因为递归默认是left==right来计算下次递归。
            //若==又可能进行了一次left++ 则递归时少了一个需排序数
            if (flag) {//基准在左边
                if (source[left] < source[right]) {
                    //如果基准在左边，右边哨兵大于基准，右哨兵左移;
                    right--;
                    continue;
                }
                exchage(source, left, right);
                left++;
                flag = false; //交换后基准在右边
            } else { //基准在右边
                if (source[left] < source[right]) {
                    //如果基准在右边，左边哨兵小于基准，左哨兵右移;
                    left++;
                    continue;
                }
                exchage(source, left, right);
                right--;
                flag = true; //交换后基准在左边
            }
        }
        quickSortRecursionVersion2(source, begin, left - 1);
        quickSortRecursionVersion2(source, left + 1, end);

    }


    private static void exchage(int[] source, int left, int right) {
        if (left >= right)
            return;
        source[left] ^= source[right];
        source[right] ^= source[left];
        source[left] ^= source[right];
    }
}
