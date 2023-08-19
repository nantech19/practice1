package com.nandu.pro.javapractice1.services;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Unmodifiable;

import java.util.ArrayList;
import java.util.List;


public class MineRecursion {

    public static List<List<Integer>> createPowerSet(List<Integer> inputInts){
        List<List<Integer>> powerSetResult = new ArrayList<>();
        powerSetResult.add(new ArrayList<>());

        for (Integer element: inputInts) {
            int size = powerSetResult.size();
            for(int i = 0; i< size; i++){
                List<Integer> integers = powerSetResult.get(i);
                List<Integer> currentSubSet = new ArrayList<>(integers);
                currentSubSet.add(element);

                powerSetResult.add(currentSubSet);
            }
        }

        return powerSetResult;
    }
}
