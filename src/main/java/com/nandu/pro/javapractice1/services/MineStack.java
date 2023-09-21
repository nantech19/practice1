package com.nandu.pro.javapractice1.services;

import java.util.*;

public class MineStack {

    public static boolean balancedBrackets(String str) {
        Stack<Character> characterStack = new Stack<>();
        Set<Character> supportedChar = Set.of('(', '[', '{', ')', ']', '}');

        for (char ch : str.toCharArray()) {
            try {
                if (ch == '(' || ch == '{' || ch == '[') {
                    characterStack.push(ch);
                } else if (!characterStack.isEmpty() && ch == ')' && characterStack.peek() == '(') {
                    characterStack.pop();
                } else if (!characterStack.isEmpty() && ch == '}' && characterStack.peek() == '{') {
                    characterStack.pop();
                } else if (!characterStack.isEmpty() && ch == ']' && characterStack.peek() == '[') {
                    characterStack.pop();
                } else if (!supportedChar.contains(ch)) {
                    continue;
                } else {
                    return false;
                }
            } catch (EmptyStackException e) {
                return false;
            }

        }
        return characterStack.isEmpty();
    }

    public static List<Integer> sunsetViews(int[] buildings, String direction) {
        Stack<Integer> buildStack = new Stack<>();

        for (int i = 0; i < buildings.length; i++) {
            if (buildStack.isEmpty()) {
                buildStack.push(i);
            } else {
                while (!buildStack.isEmpty() && buildings[i] >= buildings[buildStack.peek()]) {
                    buildStack.pop();
                }
                buildStack.push(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!buildStack.isEmpty()) {
            res.add(buildStack.pop());
        }

        if (direction == "EAST") {
            return res;
        } else {
            Collections.reverse(res);
            return res;
        }
    }

    public String bestDigits(String number, int numDigits) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            while (numDigits > 0 && !stack.isEmpty() && number.charAt(i) > stack.peek()) {
                numDigits--;
                stack.pop();
            }
            stack.push(number.charAt(i));
        }

        while (numDigits > 0) {
            numDigits--;
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
