package com.pismery.study.structure.table;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 盒子
 * @since 2022/3/3
 */
public class SkipTableTest {

    @Test
    public void test01() {
        SkipTable skipTable = new SkipTable();

        skipTable.add(41);
        skipTable.add(0);
        skipTable.add(31);
        skipTable.add(20);
        skipTable.add(31);
        skipTable.add(40);
        skipTable.add(23);
        skipTable.add(36);
        skipTable.add(31);
        skipTable.add(6);
        skipTable.add(13);
        skipTable.add(32);
        skipTable.add(19);
        skipTable.add(26);
        skipTable.add(27);
        skipTable.add(32);
        skipTable.add(5);
        skipTable.add(14);
        skipTable.add(33);
        skipTable.add(16);
        skipTable.add(13);
        skipTable.add(14);
        skipTable.erase(1);
        skipTable.search(20);
        skipTable.search(13);
        skipTable.erase(24);
        skipTable.erase(23);
        skipTable.add(18);
        skipTable.search(27);
        skipTable.add(2);
        skipTable.search(21);
        skipTable.search(28);
        skipTable.add(21);
        skipTable.add(30);
        skipTable.add(13);
        skipTable.add(30);
        skipTable.erase(11);
        skipTable.search(10);
        skipTable.search(39);
        skipTable.erase(12);
        skipTable.search(29);
        skipTable.add(24);
        skipTable.erase(27);
        System.out.println(skipTable.search(24));
        skipTable.printAll();
    }


    @Test
    public void test02() {
        SkipTable skipTable = new SkipTable();
        skipTable.add(16);
        skipTable.add(5);
        skipTable.add(14);
        // skipTable.printAll();
        skipTable.add(13);
        skipTable.add(0);
        skipTable.add(3);
        skipTable.add(12);
        skipTable.add(9);
        skipTable.add(12);
        skipTable.erase(3);
        skipTable.search(6);
        skipTable.add(7);
        skipTable.erase(0);
        skipTable.erase(1);
        skipTable.erase(10);
        skipTable.add(5);
        skipTable.search(12);
        skipTable.search(7);
        skipTable.search(16);
        skipTable.erase(7);
        skipTable.search(0);
        skipTable.add(9);
        skipTable.add(16);
        skipTable.add(3);
        skipTable.erase(2);
        skipTable.search(17);
        skipTable.add(2);
        skipTable.search(17);
        skipTable.erase(0);
        skipTable.search(9);
        skipTable.search(14);
        // skipTable.printAll();
        skipTable.erase(1);
        skipTable.erase(6);
        skipTable.add(1);
        skipTable.erase(16);
        skipTable.search(9);
        skipTable.erase(10);
        skipTable.erase(9);
        skipTable.search(2);
        skipTable.add(3);
        skipTable.add(16);
        skipTable.erase(15);
        skipTable.erase(12);
        skipTable.erase(7);
        skipTable.add(4);
        skipTable.erase(3);
        skipTable.add(2);
        skipTable.erase(1);
        skipTable.erase(14);
        // skipTable.printAll();
        skipTable.add(13);
        skipTable.add(12);
        skipTable.add(3);
        skipTable.search(6);
        skipTable.search(17);
        skipTable.add(2);
        skipTable.erase(3);
        skipTable.search(14);
        // skipTable.printAll();
        skipTable.add(11);
        skipTable.add(0);
        skipTable.search(13);
        skipTable.add(2);
        skipTable.search(1);
        skipTable.erase(10);
        skipTable.erase(17);
        skipTable.search(0);
        skipTable.search(5);
        skipTable.erase(8);
        skipTable.search(9);
        skipTable.add(8);
        skipTable.erase(11);
        skipTable.search(10);
        skipTable.erase(11);
        skipTable.search(10);
        skipTable.erase(9);
        skipTable.erase(8);
        skipTable.search(15);
        skipTable.search(14);
        // skipTable.printAll();
        skipTable.add(1);
        skipTable.add(6);
        skipTable.add(17);
        skipTable.add(16);
        skipTable.search(13);
        skipTable.search(4);
        skipTable.search(5);
        skipTable.search(4);
        skipTable.search(17);
        skipTable.search(16);
        skipTable.search(7);
        System.out.println(skipTable.search(14));
        skipTable.search(1);

        // skipTable.printAll();
    }


}