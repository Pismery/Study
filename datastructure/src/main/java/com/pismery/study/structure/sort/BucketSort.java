package com.pismery.study.structure.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class BucketSort {


    public static void bucketSort2(int[] sources) {
        int length = sources.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //寻找数组最大值最小值
        for (int i = 0; i < length; i++) {
            max = Math.max(max, sources[i]);
            min = Math.min(min, sources[i]);
        }

        //1.建立桶
        int bucketNum = length; //当[0,9]中有10个数，防止此时桶数为零;
        List<List<Integer>> bucketTable = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketTable.add(new ArrayList<Integer>());
        }
        //2.将数据塞入桶中
        int width = (max - min + 1) / bucketNum; //每个桶的宽度;
        if (max >= width * bucketNum)
            //因为int向下取整,大于width*bucketNum的数会越界
            //因此此时将桶宽度增大1;
            width++;
        //log.debug("Source[" + max + "," + min + "]: bucketNum=" + bucketNum + ";width=" + width);
        for (int i = 0; i < length; i++) {
            //log.debug("sources[i]= " + sources[i] + ";index= " + (sources[i] - min) / width);
            bucketTable.get((sources[i] - min) / width).add(sources[i]);
        }
        //3. 对每个桶进行排序
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucketTable.get(i));
        }
        //4. 重新赋值到Sources
        int index = 0;
        for (List<Integer> bucketList : bucketTable) {
            for (Integer value : bucketList) {
                sources[index++] = value;
            }
        }
    }

    /**
     * 桶选择是数组数据大小[min,max]/length +1;
     * 1.数据范围大；数目少；分组很多，许多组为空；
     * 2.数据范围大；数目多；平均；
     * 3.数据范围小；数目少；平均；
     * 4.数据范围小；数目多； 桶剩一个；
     *
     * @param sources
     */
    public static void bucketSort(int[] sources) {
        int length = sources.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //寻找数组最大值最小值
        for (int i = 0; i < length; i++) {
            max = Math.max(max, sources[i]);
            min = Math.min(min, sources[i]);
        }
        //1.建立桶
        int bucketNum = (max - min) / length + 1; //当[0,9]中有10个数，防止此时桶数为零;
        List<List<Integer>> bucketTable = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketTable.add(new ArrayList<Integer>());
        }
        //2.将数据塞入桶中
        for (int i = 0; i < length; i++) {
            bucketTable.get((sources[i] - min) / length).add(sources[i]);
        }
        //3. 对每个桶进行排序
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucketTable.get(i));
        }
        //4. 重新赋值到Sources
        int index = 0;
        for (List<Integer> bucketList : bucketTable) {
            for (Integer value : bucketList) {
                sources[index++] = value;
            }
        }
    }

}
