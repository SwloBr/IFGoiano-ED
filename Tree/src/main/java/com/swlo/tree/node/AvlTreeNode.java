package com.swlo.tree.node;

public class AvlTreeNode<T extends Comparable<T>> {
    
    
    private int height;
    private int balanceFactor;
    
    private T element;
    private AvlTreeNode<T> parent;
    private AvlTreeNode<T> leftChild;
    private AvlTreeNode<T> rightChild;

    
    
    public AvlTreeNode(T element) {
        this.element = element;
        this.height = 1;
        this.balanceFactor = 0;
    }

    public AvlTreeNode(T element, AvlTreeNode<T> parent) {
        this.element = element;
        this.parent = parent;
        this.height = 1;
        this.balanceFactor = 0;
    }


    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }



    public AvlTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(AvlTreeNode<T> parent) {
        this.parent = parent;
    }

    public AvlTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AvlTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public AvlTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(AvlTreeNode<T> rightChild) {
        this.rightChild = rightChild;
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