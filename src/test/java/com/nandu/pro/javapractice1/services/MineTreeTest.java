package com.nandu.pro.javapractice1.services;

import com.nandu.pro.javapractice1.model.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MineTreeTest {

    @Test
    void branchSum() {
        BinaryTree binaryTree6 =new BinaryTree(6);
        BinaryTree binaryTree7 =new BinaryTree(7);
        BinaryTree binaryTree8 =new BinaryTree(8);
        BinaryTree binaryTree9 =new BinaryTree(9);
        BinaryTree binaryTree10 =new BinaryTree(10);

        BinaryTree binaryTree5 =new BinaryTree(5,binaryTree10,null);
        BinaryTree binaryTree4 =new BinaryTree(4,binaryTree8,binaryTree9);
        BinaryTree binaryTree3 =new BinaryTree(3,binaryTree6,binaryTree7);
        BinaryTree binaryTree2 =new BinaryTree(2,binaryTree4,binaryTree5);
        BinaryTree binaryTree1 =new BinaryTree(1,binaryTree2,binaryTree3);
        List<Integer> integers = MineTree.branchSum(binaryTree1);
        integers.forEach(System.out::println);
    }
}