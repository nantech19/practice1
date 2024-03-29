package com.nandu.pro.javapractice1.services;

import java.util.*;

public class MineString {

    public static String[] commonCharacters(String[] strings) {
        Map<String, Integer> charCountMap = new HashMap<>();
        for (String eachString : strings) {
            Set<String> eachCharArray = new HashSet();
            for (int i = 0; i < eachString.toCharArray().length; i++) {
                eachCharArray.add(String.valueOf(eachString.toCharArray()[i]));
            }
            eachCharArray.forEach(s -> {
                if (charCountMap.containsKey(s)) {
                    int currentVal = charCountMap.get(s);
                    charCountMap.put(s, currentVal + 1);
                } else {
                    charCountMap.put(s, 1);
                }
            });
        }
        return charCountMap.entrySet()
                .stream()
                .filter(a -> a.getValue() == strings.length)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }

    public int firstNonRepeatingCharacter(String string) {
        if (string == null) {
            return -1;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();
        char[] stringArray = string.toCharArray();

        for (char c : stringArray) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        for (int i = 0; i < stringArray.length; i++) {
            if (charCountMap.getOrDefault(stringArray[i], 0) == 1) {
                return i;
            }
        }
        return -1;

    }

    public static boolean generateDocument(String characters, String document) {
        // Create a map DS to keep track of each character count
        // loop around characters
        // add chars to the map and keep on increaing if they already exist in the map
        // loop around the document
        // for each element hit reduce the number of occurance
        // if your map is having all the element count as zero return true else false

        Map<Character, Integer> charCount = new HashMap<>();
        for (char char1 : characters.toCharArray()) {
            if (charCount.containsKey(char1)) {
                charCount.put(char1, charCount.get(char1) + 1);
            } else {
                charCount.put(char1, 1);
            }
        }
        for (char char2 : document.toCharArray()) {
            if (charCount.containsKey(char2)) {
                charCount.put(char2, charCount.get(char2) - 1);
            } else {
                return false;
            }
        }
        return charCount.values().stream().allMatch(a -> a >= 0);
    }

    public static String longestPalindrome(String str) {
        String substringLength = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String subPartOfString = str.substring(i, j + 1);
                if (subPartOfString.length() > substringLength.length()
                        && isPallindrome(subPartOfString)) {
                    substringLength = subPartOfString;
                }
            }
        }

        return substringLength;
    }

    public static boolean isPallindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        System.out.println("found True ->" + str);
        return true;
    }


    public static char[] minimumCharactersForWords(String[] words) {
        Map<Character, Integer> freqCount = new HashMap<>();

        for (String word : words) {
            Map<Character, Integer> currentFreq = new HashMap<>();

            for (int j = 0; j < word.length(); j++) {
                char[] currentWord = word.toCharArray();
                if (currentFreq.containsKey(currentWord[j])) {
                    currentFreq.put(currentWord[j], currentFreq.get(currentWord[j]) + 1);
                } else {
                    currentFreq.put(currentWord[j], 1);
                }
            }
            updateMaxFreq(currentFreq, freqCount);
        }

        return freqCount.entrySet().stream()
                .flatMap(a -> {
                    List<Character> collect = java.util.stream.Stream.generate(a::getKey)
                            .limit(a.getValue())
                            .collect(java.util.stream.Collectors.toList());
                    return collect.stream();
                }).map(Character::charValue) // Convert Character objects to char primitives
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString()
                .toCharArray();
    }

    private static void updateMaxFreq(Map<Character, Integer> temp, Map<Character, Integer> result) {

        for (Map.Entry<Character, Integer> aVal : temp.entrySet()) {
            if (result.containsKey(aVal.getKey())) {
                result.put(aVal.getKey(), Math.max(aVal.getValue(), result.get(aVal.getKey())));
            } else {
                result.put(aVal.getKey(), aVal.getValue());
            }
        }
    }
}
