package com.swlo.tree.trees;

import com.swlo.tree.node.BinaryTreeNode;

public abstract class GenericTree<T extends Comparable<T>> {

    private BinaryTreeNode<T> root;

    public abstract void add(T element);

    public abstract void remove(T element);

    public abstract BinaryTreeNode<T> search(T element);

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }
}
