package com.nandu.pro.javapractice1.services;

import java.util.*;
import java.util.stream.Collectors;


public class MineRecursion {

    public static List<List<Integer>> createPowerSet(List<Integer> inputInts) {
        List<List<Integer>> powerSetResult = new ArrayList<>();
        powerSetResult.add(new ArrayList<>());

        for (Integer element : inputInts) {
            int size = powerSetResult.size();
            for (int i = 0; i < size; i++) {
                List<Integer> integers = powerSetResult.get(i);
                List<Integer> currentSubSet = new ArrayList<>(integers);
                currentSubSet.add(element);

                powerSetResult.add(currentSubSet);
            }
        }

        return powerSetResult;
    }

    public static List<String> phoneNumberMnemonics(String phoneNumber) {
        Map<String, List<String>> phoneNumberMap = new HashMap<>();
        phoneNumberMap.put("1", List.of());
        phoneNumberMap.put("2", List.of("a", "b", "c"));
        phoneNumberMap.put("3", List.of("d", "e", "f"));
        phoneNumberMap.put("4", List.of("g", "h", "i"));
        phoneNumberMap.put("5", List.of("j", "k", "l"));
        phoneNumberMap.put("6", List.of("m", "n", "o"));
        phoneNumberMap.put("7", List.of("p", "q", "r", "s"));
        phoneNumberMap.put("8", List.of("t", "u", "v"));
        phoneNumberMap.put("9", List.of("w", "x", "y", "z"));
        phoneNumberMap.put("0", List.of());

//        1
//           9w,9x,9y,9z
        List<String> collect1 = new ArrayList<>();
        phoneNumber.chars()
                .mapToObj(a -> (char) a)
                .map(Object::toString)
                .map(b -> {
                    if (phoneNumberMap.get(b).size() == 0) {
                        List<String> strings = List.of(new String(b));
                        return strings.stream().reduce("", (m, n) -> m + n);
                    }
                    List<String> currentMappedString = phoneNumberMap.get(b);
                    List<String> collect = currentMappedString.stream()
                            .map(String::new)
                            .collect(Collectors.toList());
                    return collect.stream().reduce("", (m, n) -> m + n);
                })
                .collect(Collectors.toList());


        return collect1;
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<Integer> copyArray= new ArrayList<>();
        array.forEach(a-> copyArray.add(a));

        List<List<Integer>> permResult= new ArrayList<>();
        // if(array.size()==0){
        //   return permResult;
        // }
        // base case
        if(copyArray.size()==1){
           // List<List<Integer>> copy1Array= new ArrayList<>();
            List<Integer> copy2Array= new ArrayList<>();

            copy2Array.add(copyArray.get(0));
         //   copy1Array.add(copy2Array);
            return new ArrayList<List<Integer>>(Collections.singleton(copy2Array));
           // return copy1Array;
//            array.forEach(a-> copy1Array.add(a));
//            return List.of(List.of(copyArray.get(0)));
        }
        for(int i=0 ; i< copyArray.size(); i++){  // 1,2,3-- 2,3
            int removedInt = copyArray.remove(0);//2,3 --3
            List<List<Integer>> currentPerm= getPermutations(copyArray); //[[3]]

            for(List<Integer> perm: currentPerm){
                perm.forEach(a-> System.out.print(a));
                perm.add(removedInt);  //[2,3] [3,2]
            }
            permResult.addAll(currentPerm);
            copyArray.add(removedInt);
        }
        return permResult;
    }

}
