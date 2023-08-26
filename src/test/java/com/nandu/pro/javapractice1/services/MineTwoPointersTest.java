package com.nandu.pro.javapractice1.services;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MineTwoPointersTest {

    @Test
    void moveElementToEnd() {
        List<Integer> array = Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2);
        List<Integer> integers = MineTwoPointers.moveElementToEnd(array, 2);
    }

    @Test
    void mergeOverlappingIntervals() {
        int[][] interval = {
            {
                1, 2
            },
            {
                3, 5
            },
            {
                4, 7
            },
            {
                6, 8
            },
            {
                9, 10
            }
        };
        int[][] ints = MineTwoPointers.mergeOverlappingIntervals(interval);
    }

    @Test
    void sweetAndSavory() {
        int[] ints = MineTwoPointers.sweetAndSavory(new int[]{-3, -5, 1, 7}, 8);
        Arrays.stream(ints).forEach(System.out::println);

    }
}