package com.pismery.study.algorithm.search;

public class Sqrt {

    /**
     * 求x的根方sqrt
     * 一个数的sqrt一定在[1,x]之间，根据sqrt == x / sqrt，通过二分法查找;
     *
     * @param x the sqrt parameter
     * @return
     *  if x = 2 return 1;
     *  if x = 4 return 2;
     *  if x = 8 return 2;
     *  if x = 9 return 3;
     */
    public static int sqrt(int x) {
        if (x <= 0) return -1;

        int left = 1;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sqrt = x / mid;
            if (sqrt == mid)
                return mid;
            else if(sqrt < mid)
                right = mid - 1;
            else
                left = mid + 1;
        }
        //由于left <= right 最终得到的结果right < left;而方法向下取整，因此返回right;
        return right;
    }
}
