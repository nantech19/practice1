package com.nandu.pro.javapractice1.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.Min;
import java.util.List;


public class MineRecursionTest {

    @Test
    public void createPowerSet() {
        List<List<Integer>> powerSet = MineRecursion.createPowerSet(List.of(1, 2, 3));

        Assertions.assertThat(powerSet).isNotEmpty();
        Assertions.assertThat(powerSet).containsExactlyInAnyOrderElementsOf(List.of(
                List.of(),
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(1, 2),
                List.of(1, 3),
                List.of(2, 3),
                List.of(1, 2, 3))
        );
    }

    @Test
    void phoneNumberMnemonics() {
        List<String> strings = MineRecursion.phoneNumberMnemonics("1905");
    }
}