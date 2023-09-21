package com.nandu.pro.javapractice1.services;

import org.junit.jupiter.api.Test;

class MineStringTest {

    @Test
    void commonCharacters() {
//        String[] strings = MineString.commonCharacters(new String[]{"abc", "bcd", "cbad"});
        String[] strings1 = MineString.commonCharacters(new String[]{"aa", "aa"});
    }

    @Test
    void firstNonRepeatingCharacter() {
        System.out.print("hello");
    }

    @Test
    void generateDocument() {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";

        MineString.generateDocument(characters, document);

    }

    @Test
    void longestPalindrome() {
        String abaxyzzyxf = MineString.longestPalindrome("abaxyzzyxf");
    }


    @Test
    void isPallindrome() {
    }

    @Test
    void minimumCharactersForWords() {
        String[] input = new String[]{"this", "that", "did", "deed", "them!", "a"};
        MineString.minimumCharactersForWords(input);
    }

}