package com.swlo.tree;

public class TreeNode<T extends Comparable<T>> implements Comparable<TreeNode<T>> {

    private T element;
    private TreeNode<T> dad;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode(T element) {
        this.element = element;
    }

    public TreeNode(T element, TreeNode<T> dad) {
        this.element = element;
        this.dad = dad;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public TreeNode<T> getDad() {
        return dad;
    }

    public void setDad(TreeNode<T> dad) {
        this.dad = dad;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }


    @Override
    public int compareTo(TreeNode<T> o) {
        return 0;
    }
}
