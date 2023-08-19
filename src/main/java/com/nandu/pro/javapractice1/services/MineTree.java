package com.nandu.pro.javapractice1.services;

import com.nandu.pro.javapractice1.model.BinaryTree;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service
public class MineTree {


    public static List<Integer> branchSum(BinaryTree binaryTree) {
        List<Integer> result = new ArrayList<>();

        Stack<Pair<BinaryTree, Integer>> nodeStack = new Stack<>();
        nodeStack.add(Pair.of(binaryTree, binaryTree.value));

        while (!nodeStack.isEmpty()) {
            Pair<BinaryTree, Integer> currentNodePair = nodeStack.pop();
            if (currentNodePair.getFirst().left == null && currentNodePair.getFirst().right == null) {
                result.add(currentNodePair.getSecond());
            }

            if (currentNodePair.getFirst().right != null) {
                nodeStack.push(Pair.of(
                        currentNodePair.getFirst().right,
                        currentNodePair.getSecond() + currentNodePair.getFirst().right.value));
            }
            if (currentNodePair.getFirst().left != null) {
                nodeStack.push(Pair.of(
                        currentNodePair.getFirst().left,
                        currentNodePair.getSecond() + currentNodePair.getFirst().left.value));
            }

            System.out.println("----");
        }
        return result;
    }
}
