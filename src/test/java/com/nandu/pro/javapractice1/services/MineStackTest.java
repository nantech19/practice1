package com.nandu.pro.javapractice1.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MineStackTest {

    @Test
    void balancedBrackets() {
        String input = "(141[])(){waga}((51afaw))()hh()";
        boolean b = MineStack.balancedBrackets(input);

        Assertions.assertThat(b).isTrue();
    }

    @Test
    void sunsetViews() {
        List<Integer> integers = MineStack.sunsetViews(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "EAST");

        Assertions.assertThat(List.of(1, 3, 6, 7)).containsExactlyInAnyOrderElementsOf(integers);
    }
}