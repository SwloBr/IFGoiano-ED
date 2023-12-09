package com.swlo.tree.node;

public class RedBlackTreeNode<T extends Comparable<T>> {


    private T element;
    private RedBlackTreeNode<T> parent;
    private RedBlackTreeNode<T> leftChild;
    private RedBlackTreeNode<T> rightChild;
    private boolean color;

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public RedBlackTreeNode(T element) {
        this.element = element;
    }


    public RedBlackTreeNode(T element, RedBlackTreeNode<T> parent) {
        this.element = element;
        this.parent = parent;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public RedBlackTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(RedBlackTreeNode<T> parent) {
        this.parent = parent;
    }

    public RedBlackTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(RedBlackTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public RedBlackTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(RedBlackTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }


}