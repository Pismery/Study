package com.pismery.study.util;

import org.springframework.util.CollectionUtils;

import java.util.List;

public class CompareUtils {
    /**
     * 比较两个List集合是否相等
     * <p>注：1. 如果一个List的引用为<code>null</code>，或者其包含的元素个数为0，那么该List在本逻辑处理中都算作空；
     * <p>2. 泛型参数E涉及到对象，所以需要确保正确实现了对应对象的<code>equal()</code>方法。
     *
     * @param list1 list1
     * @param list2 list2
     * @return bool
     */
    public static <E> boolean isListEqual(List<E> list1, List<E> list2) {
        // 两个list引用相同（包括两者都为空指针的情况）
        if (CollectionUtils.isEmpty(list1) && CollectionUtils.isEmpty(list2)) {
            return true;
        }
        
        // 两个list元素个数不相同
        if (list1.size() != list2.size()) {
            return false;
        }
        
        // 两个list元素个数已经相同，再比较两者内容
        // 采用这种可以忽略list中的元素的顺序
        // 涉及到对象的比较是否相同时，确保实现了equals()方法
        return list1.containsAll(list2);
    }
}
