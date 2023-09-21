package com.nandu.pro.javapractice1.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MineSlidingWindowTest {

    @Test
    void findMaxAverage() {
        double maxAverage = MineSlidingWindow.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
        Assertions.assertEquals(maxAverage, 12.75000);
    }

    @Test
    void longestSubstringWithoutDuplication() {
        String clementisacap = MineSlidingWindow.longestSubstringWithoutDuplication("clementisacap");

        Assertions.assertEquals(clementisacap, "mentisac");

    }
}