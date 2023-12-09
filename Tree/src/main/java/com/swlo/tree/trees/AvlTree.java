package com.swlo.tree.trees;

import com.swlo.tree.node.AvlTreeNode;
import com.swlo.tree.util.PrintEnum1;

import java.util.List;


public class AvlTree<T extends Comparable<T>> {


    private AvlTreeNode<T> root;

    public AvlTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(AvlTreeNode<T> root) {
        this.root = root;
    }

    public void add(T element) {
        root = add(root, element);
    }

    private AvlTreeNode<T> add(AvlTreeNode<T> node, T element) {
        if (node == null) {
            return new AvlTreeNode<>(element);
        }
        int compareResult = element.compareTo(node.getElement());
        if (compareResult < 0) {
            node.setLeftChild(add(node.getLeftChild(), element));
        } else if (compareResult > 0) {
            node.setRightChild(add(node.getRightChild(), element));
        } else {
            return node;
        }
        return balance(node);
    }

    public void remove(T element) {
        root = remove(root, element);
    }

    private AvlTreeNode<T> remove(AvlTreeNode<T> node, T element) {
        if (node == null) {
            return null;
        }
        int compareResult = element.compareTo(node.getElement());
        if (compareResult < 0) {
            if (node.getLeftChild() != null) {
                node.setLeftChild(remove(node.getLeftChild(), element));
            }
        } else if (compareResult > 0) {
            if (node.getRightChild() != null) {
                node.setRightChild(remove(node.getRightChild(), element));
            }
        } else if (node.getLeftChild() != null && node.getRightChild() != null) {
            node.setElement(findMin(node.getRightChild()).getElement());
            if (node.getRightChild() != null) {
                node.setRightChild(remove(node.getRightChild(), node.getElement()));
            }
        } else {
            node = (node.getLeftChild() != null) ? node.getLeftChild() : node.getRightChild();
        }
        return balance(node);
    }

    private AvlTreeNode<T> findMin(AvlTreeNode<T> node) {
        if (node == null) {
            return node;
        }
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node;
    }


    public AvlTreeNode<T> search(T element) {

        if (getRoot() == null) {
            return null;
        }

        AvlTreeNode<T> current = getRoot();

        while (true) {
            if (element.compareTo(current.getElement()) < 0) {
                if (current.getLeftChild() == null) {
                    return null;
                } else {
                    current = current.getLeftChild();
                }
            }
            if (element.compareTo(current.getElement()) > 0) {
                if (current.getRightChild() == null) {
                    return null;
                } else {
                    current = current.getRightChild();
                }
            }

            if (element.compareTo(current.getElement()) == 0) {
                return current;
            }
        }

    }

    /* AVL METHODS START*/

    private int height(AvlTreeNode<T> node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    private int balanceFactor(AvlTreeNode<T> node) {
        return height(node.getLeftChild()) - height(node.getRightChild());
    }

    private AvlTreeNode<T> rotateRight(AvlTreeNode<T> node) {
        AvlTreeNode<T> leftChild = node.getLeftChild();
        node.setLeftChild(leftChild.getRightChild());
        leftChild.setRightChild(node);
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        leftChild.setHeight(Math.max(height(leftChild.getLeftChild()), node.getHeight()) + 1);
        return leftChild;
    }

    private AvlTreeNode<T> rotateLeft(AvlTreeNode<T> node) {
        AvlTreeNode<T> rightChild = node.getRightChild();
        node.setRightChild(rightChild.getLeftChild());
        rightChild.setLeftChild(node);
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        rightChild.setHeight(Math.max(height(rightChild.getRightChild()), node.getHeight()) + 1);
        return rightChild;
    }

    private AvlTreeNode<T> balance(AvlTreeNode<T> node) {

        if (balanceFactor(node) == -2) {

            if (balanceFactor(node.getRightChild()) > 0) {
                node.setRightChild(rotateRight(node.getRightChild()));
            }
            node = rotateLeft(node);
        } else if (balanceFactor(node) == 2) {
            if (balanceFactor(node.getLeftChild()) < 0) {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            node = rotateRight(node);
        }
        return node;
    }


    /* AVL METHODS END*/


    @SuppressWarnings("unchecked")
    public List<T> getOrdered(PrintEnum1 type) {

        return (List<T>) type.getFunction().apply(getRoot());
    }


}