package com.swlo.tree.node;

public class BinaryTreeNode<T extends Comparable<T>> implements Comparable<BinaryTreeNode<T>> {

    private T element;
    private BinaryTreeNode<T> parent;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(T element) {
        this.element = element;
    }


    public BinaryTreeNode(T element, BinaryTreeNode<T> parent) {
        this.element = element;
        this.parent = parent;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode<T> parent) {
        this.parent = parent;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }


    @Override
    public int compareTo(BinaryTreeNode<T> o) {
        return 0;
    }
}
