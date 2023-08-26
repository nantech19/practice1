package com.nandu.pro.javapractice1.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class MineTwoPointers {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        System.out.println("before " + array);
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

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {

        int[][] sortedIntervals=intervals.clone();
        Arrays.sort(sortedIntervals,(a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> mergedIntervals= new ArrayList<>();
        int[] currentInterval= sortedIntervals[0];
        mergedIntervals.add(currentInterval);

        for(int[] nextInterval: sortedIntervals){
            int currentIntervalEnd= currentInterval[1];
            int nextIntervalStart= nextInterval[0];
            int nextIntervalEnd= nextInterval[1];

            if(currentIntervalEnd >= nextIntervalStart){
                currentInterval[1]= Math.max(currentIntervalEnd,nextIntervalEnd);
            }
            else{
                currentInterval=nextInterval;
                mergedIntervals.add(currentInterval);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static int[] sweetAndSavory(int[] dishes, int target) {
        List<Integer> sweetDishes= new ArrayList<>();
        List<Integer> savoryDishes= new ArrayList<>();
        for(int dish: dishes){
            if(dish<0){
                sweetDishes.add(dish);
            }else{
                savoryDishes.add(dish);
            }
        }

        sweetDishes.sort(Comparator.comparingInt(Math::abs));  // o(n*logn) because of sorting
        savoryDishes.sort(Comparator.naturalOrder());// o(n*logn) because of sorting


        int[] result= new int[2];
        int startSweet=0;
        int startSavory=0;
        int reachToTarget=Integer.MAX_VALUE;
        while(startSweet< sweetDishes.size() && startSavory< savoryDishes.size()){
            int currentSweet=sweetDishes.get(startSweet);
            int currentSavory=savoryDishes.get(startSweet);
            int currentDiff=currentSweet +currentSavory;
            System.out.println(currentDiff);
            if(currentDiff <= target){  // because not too savoury
                int currentReach=target-currentDiff;
                if(currentReach < reachToTarget){
                    reachToTarget=currentReach;
                    result[0]=currentSweet;
                    result[1]=currentSavory;
                }
                startSavory++;
            }
            else {
                startSweet++;
            }
        }
        return result;
    }



//    [1,2,3,4,6,8,9]     // (n*logn)
//     ^           ^    =10
//       ^         ^    =11
//         ^       ^    =12
//           ^     ^    =13
//             ^   ^    =15
//             ^ ^      =14  o(n)

//    14




}
