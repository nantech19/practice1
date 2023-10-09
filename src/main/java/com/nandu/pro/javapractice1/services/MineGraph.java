package com.nandu.pro.javapractice1.services;

import java.util.*;

public class MineGraph {

    public static List<Integer> topologicalSort(List<Integer> jobs, List<int[]> deps) {
        Map<Integer, List<Integer>> graph = createAdjacencyList(deps);

        List<Integer> result = new ArrayList<>();
        Set<Integer> visitedNode = new HashSet<>();
        for (int aJob : jobs) {
            runDfs(graph, aJob, visitedNode, result);
        }
        return result;
    }

    private static void runDfs(Map<Integer, List<Integer>> graph, Integer key, Set<Integer> visitedNode, List<Integer> result) {
        if (key == null) {
            return;
        }
        if (visitedNode.contains(key)) {
            return;
        }
        visitedNode.add(key);
        result.add(key);
        for (Integer neighbour : graph.get(key)) {
            runDfs(graph, neighbour, visitedNode, result);
        }
    }

    public static Map<Integer, List<Integer>> createAdjacencyList(List<int[]> jobDependency) {
        Map<Integer, List<Integer>> adjacent = new HashMap<>();
        for (int[] ints : jobDependency) {
            adjacent.putIfAbsent(ints[0], new ArrayList<>());
            adjacent.putIfAbsent(ints[1], new ArrayList<>());
            adjacent.get(ints[0]).add(ints[1]);
        }
        System.out.println(adjacent);
        return adjacent;
    }

}
