package com.nandu.pro.javapractice1.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwoPointers {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        System.out.println("before "+array);
        int first = 0;
        int last = array.size() - 1;
        while (first < last) {
            while (first < last && array.get(last) == toMove) {
                last--;
            }
            if (array.get(first) == toMove) {
                int temp = array.get(last);
                array.set(last, array.get(first));
                array.set(first, temp);
            }
            first++;
        }
        System.out.println("after "+array);
        return array;
    }


}
