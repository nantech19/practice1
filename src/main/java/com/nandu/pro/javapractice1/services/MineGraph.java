package com.nandu.pro.javapractice1.services;

import java.util.*;

public class MineGraph {
    public static List<Integer> findBuildOrder(int numTables, int[][] dependencies) {
        // Create adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>(numTables);
        for (int i = 0; i < numTables; i++) {
            graph.add(new ArrayList<>());
        }

        // Calculate in-degrees for each table
        int[] inDegree = new int[numTables];
        for (int[] dependency : dependencies) {
            int parent = dependency[1];
            int child = dependency[0];
            graph.get(parent).add(child);
            inDegree[child]++;
        }

        // Perform topological sorting using a queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numTables; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int table = queue.poll();
            result.add(table);
            for (int neighbor : graph.get(table)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Check for circular dependencies
        if (result.size() != numTables) {
            return Collections.emptyList(); // Circular dependencies detected
        }

        return result;
    }

    public static void main(String[] args) {
        int numTables = 4;
        int[][] dependencies = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        List<Integer> buildOrder = findBuildOrder(numTables, dependencies);
        if (buildOrder.isEmpty()) {
            System.out.println("Error: Circular Dependencies");
        } else {
            System.out.println("Build Order: " + buildOrder);
        }
    }

    public static List<Integer> findBuildOrderDfs(int numTables, int[][] dependencies) {
        // Create adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>(numTables);
        for (int i = 0; i < numTables; i++) {
            graph.add(new ArrayList<>());
        }

        // Calculate in-degrees for each table
        int[] inDegree = new int[numTables];
        for (int[] dependency : dependencies) {
            int parent = dependency[1];
            int child = dependency[0];
            graph.get(parent).add(child);
            inDegree[child]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numTables; i++) {
            if (inDegree[i] == 0) {
//                dfs(i, graph, result);
//                run dfs here
            }
        }

        // Check for circular dependencies
        if (result.size() != numTables) {
            return Collections.emptyList(); // Circular dependencies detected
        }

        // Reverse the result to get the correct build order
        Collections.reverse(result);
        return result;
    }

   /* private static void dfs(int table, List<List<Integer>> graph, List<Integer> result) {
        result.add(table);
        for (int neighbor : graph.get(table)) {
            if (--inDegree[neighbor] == 0) {
                dfs(neighbor, graph, result);
            }
        }
    }*/

}
