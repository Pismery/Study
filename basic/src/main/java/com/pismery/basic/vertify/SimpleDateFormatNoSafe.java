package com.pismery.basic.vertify;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * SimpleDateFormat is no safe;
 * 下面运行结果发现不仅会出现异常同时还有可能格式化出不一致的现象；
 * 原因：
 * SimpeDateFormat的父类DateFormat中有一个Calender的protected字段
 * <p></p>
 * 假设：有两个线程持有了同一个SimpleDateFormat的实例，分别调用format方法：
 * <ol>
 * <li>线程1调用format方法，改变了calendar这个字段。</li>
 * <li>中断来了。</li>
 * <li>线程2开始执行，它也改变了calendar。</li>
 * <li>又中断了。</li>
 * <li>线程1回来了，此时，calendar已然不是它所设的值，而是走上了线程2设计的道路。</li>
 * </ol>
 */
public class SimpleDateFormatNoSafe {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = "2016-12-30 15:35:34";
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int num = 0; num < 5; num++) {
                    try {
                        System.out.println(
                                Thread.currentThread().getName() + "\t" + dateFormat.parse(dateTime));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
