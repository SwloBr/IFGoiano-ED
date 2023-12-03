package com.swlo.tree.trees;

import com.swlo.tree.node.AvlTreeNode;
import com.swlo.tree.node.BinaryTreeNode;

public class AvlTree<T extends Comparable<T>> extends BinaryTree<T>{

    @Override
    public void add(T element) {
        if (getRoot() == null) {
            setRoot(new AvlTreeNode<>(element));
            return;
        }

        AvlTreeNode<T> current = (AvlTreeNode<T>) getRoot();

        while (true) {
            if (element.compareTo(current.getElement()) < 0) {
                if (current.getLeftChild() == null) {
                    current.setLeftChild(new AvlTreeNode<>(element, current));
                    break;
                } else {
                    current = (AvlTreeNode<T>) current.getLeftChild();
                }
            }

            if (element.compareTo(current.getElement()) > 0) {
                if (current.getRightChild() == null) {
                    current.setRightChild(new AvlTreeNode<>(element, current));
                    break;
                } else {
                    current = (AvlTreeNode<T>) current.getRightChild();
                }
            }

            if (element.compareTo(current.getElement()) == 0) {
                break;
            }
        }
        balance(getRoot());
    }

    @Override
    public void remove(T element) {
        super.remove(element);
        balance(getRoot());
    }

    private void balance(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        }

        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.getLeftChild()) < 0) {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            node = rotateRight(node);
        } else if (balance < -1) {
            if (getBalance(node.getRightChild()) > 0) {
                node.setRightChild(rotateRight(node.getRightChild()));
            }
            node = rotateLeft(node);
        }

        if (node instanceof AvlTreeNode) {
            ((AvlTreeNode<T>) node).setBalanceFactor(balance);
        }

        balance(node.getLeftChild());
        balance(node.getRightChild());
    }

    private BinaryTreeNode<T> rotateLeft(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> newRoot = node.getRightChild();
        node.setRightChild(newRoot.getLeftChild());
        newRoot.setLeftChild(node);
        return newRoot;
    }

    private BinaryTreeNode<T> rotateRight(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> newRoot = node.getLeftChild();
        node.setLeftChild(newRoot.getRightChild());
        newRoot.setRightChild(node);
        return newRoot;
    }

    private int getHeight(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        if (!(node instanceof AvlTreeNode)) {
            return 0;
        }
        return ((AvlTreeNode<T>) node).getHeight();
    }

    private int getBalance(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeftChild()) - getHeight(node.getRightChild());
    }
}