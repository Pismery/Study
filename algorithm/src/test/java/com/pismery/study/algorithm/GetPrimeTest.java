package com.pismery.study.algorithm;

import com.pismery.study.algorithm.GetPrime;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by pismery on 2018-03-25.
 */
public class GetPrimeTest {

    @Test
    public void getPrime(){
        List<Integer> expect_2 = new ArrayList();
        expect_2.add(2);
        expect_2.add(3);

        List<Integer> expect_7 = new ArrayList();
        expect_7.add(2);
        expect_7.add(3);
        expect_7.add(5);
        expect_7.add(7);

        List<Integer> expect_10 = new ArrayList();
        expect_10.add(2);
        expect_10.add(3);
        expect_10.add(5);
        expect_10.add(7);

        assertEquals(expect_2, GetPrime.getPrime(4));
        assertEquals(expect_7, GetPrime.getPrime(7));
        assertEquals(expect_10, GetPrime.getPrime(10));
    }

    @Test
    public void getPrimeBy6N_1(){
        List<Integer> expect_2 = new ArrayList();
        expect_2.add(2);
        expect_2.add(3);

        List<Integer> expect_7 = new ArrayList();
        expect_7.add(2);
        expect_7.add(3);
        expect_7.add(5);
        expect_7.add(7);

        List<Integer> expect_10 = new ArrayList();
        expect_10.add(2);
        expect_10.add(3);
        expect_10.add(5);
        expect_10.add(7);

        assertEquals(expect_2, GetPrime.getPrimeBy6N_1(4));
        assertEquals(expect_7, GetPrime.getPrimeBy6N_1(7));
        assertEquals(expect_10, GetPrime.getPrimeBy6N_1(10));
    }

    @Test
    public void isPrime() {
        assertTrue(GetPrime.isPrime(2));
        assertTrue(GetPrime.isPrime2(2));

        assertTrue(GetPrime.isPrime(3));
        assertTrue(GetPrime.isPrime2(3));

        assertFalse(GetPrime.isPrime(4));
        assertFalse(GetPrime.isPrime2(4));

        assertFalse(GetPrime.isPrime(9));
        assertFalse(GetPrime.isPrime2(9));
    }


}
