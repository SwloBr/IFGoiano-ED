package com.swlo.tree.node;

public class AvlTreeNode<T extends Comparable<T>> extends BinaryTreeNode<T> {
    private int height;
    private int balanceFactor;

    public AvlTreeNode(T element) {
        super(element);
        this.height = 1;
        this.balanceFactor = 0;
    }

    public AvlTreeNode(T element, BinaryTreeNode<T> parent) {
        super(element, parent);
        this.height = 1;
        this.balanceFactor = 0;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }
}