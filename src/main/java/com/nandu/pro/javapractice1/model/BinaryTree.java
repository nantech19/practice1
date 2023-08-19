package com.nandu.pro.javapractice1.model;

public class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
        this.value = value;
    }

    public BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
