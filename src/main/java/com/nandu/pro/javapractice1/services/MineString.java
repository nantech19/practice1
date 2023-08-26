package com.nandu.pro.javapractice1.services;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MineString {

    public static String[] commonCharacters(String[] strings) {
        List<String>  f= new ArrayList<String>();
        Map<String,Integer> charCountMap= new HashMap<>();
        for(String eachString: strings){
            Set<String> eachCharArray = new HashSet();
            for (int i = 0; i < eachString.toCharArray().length; i++) {
                eachCharArray.add(String.valueOf(eachString.toCharArray()[i]));
            }
            for (String s : eachCharArray) {
                if (charCountMap.containsKey(s)) {
                    int currentVal = charCountMap.get(s);
                    charCountMap.put(s, currentVal + 1);
                } else {
                    charCountMap.put(s, 1);
                }
            }
        }
        return charCountMap.entrySet()
                .stream()
                .filter(a-> a.getValue() == strings.length)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
    public int firstNonRepeatingCharacter(String string) {
        if(string== null){
            return -1;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();
        char[] stringArray= string.toCharArray();

        for(int i=0; i < stringArray.length; i++){
            if(charCountMap.containsKey(stringArray[i])){
                charCountMap.put(stringArray[i], charCountMap.get(stringArray[i])+1);
            }
            else{
                charCountMap.put(stringArray[i], 1);
            }
        }

        for(int i=0; i < stringArray.length; i++){
            if(charCountMap.getOrDefault(stringArray[i],0)==1){
                return i;
            }
        }
        return -1;
    }
}
