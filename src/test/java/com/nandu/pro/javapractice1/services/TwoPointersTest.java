package com.nandu.pro.javapractice1.services;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class TwoPointersTest {

    @Test
    void moveElementToEnd() {
        List<Integer> array = Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2);
        List<Integer> integers = TwoPointers.moveElementToEnd(array, 2);
    }
}