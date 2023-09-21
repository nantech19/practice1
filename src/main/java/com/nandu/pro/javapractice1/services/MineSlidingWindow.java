package com.nandu.pro.javapractice1.services;

import java.util.Arrays;

public class MineSlidingWindow {

    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length == 0) {
            return 0d;
        }
        if (k == 0) {
            return 0d;
        }
        if (nums.length == k) {
            return Arrays.stream(nums).asDoubleStream().sum() / k;
        }
        double currentSum = 0d;
        double totalSum = Double.NEGATIVE_INFINITY;

        int windowStart = 0;// reference point
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currentSum += nums[windowEnd]; //keep on adding

            int windowLength = windowEnd - windowStart + 1; // until you reach the window length
            if (windowLength == k) {    // for dynamic it would be while loop
                totalSum = Math.max(currentSum, totalSum); // figures out max
                currentSum -= nums[windowStart];            // remove first element
                windowStart++;                              //slide window to one place forward
            }
        }
        return totalSum / k;
    }

    public static String longestSubstringWithoutDuplication(String str) {
//        StringBuilder sb= new StringBuilder();
//        Set<Character> characters = new HashSet<>();
//
//        int start=0;
//        for (int end=0; end < str.length(); end++){
//            sb.append(str.charAt(end));
//            characters.add(str.charAt(end));
//
//            while (characters.contains(str.charAt())) {
//                Integer h= 5;
//            }
//
//        }
//        IntStream.of(7).map(a-> a).collect(Collectors.toList());
//
//        return "";
        return "";
    }
}
