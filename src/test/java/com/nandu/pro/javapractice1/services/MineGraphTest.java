package com.nandu.pro.javapractice1.services;

import org.junit.jupiter.api.Test;

import java.util.List;

class MineGraphTest {

    @Test
    void topologicalSort() {
        List<Integer> jobs = List.of(1, 2, 3, 4);
        List<int[]> jobDependencies = List.of(new int[]{1, 2}, new int[]{1, 3}, new int[]{3, 2}, new int[]{4, 2}, new int[]{4, 3});

        List<Integer> integers = MineGraph.topologicalSort(jobs, jobDependencies);
        integers.forEach(System.out::println);
    }
}