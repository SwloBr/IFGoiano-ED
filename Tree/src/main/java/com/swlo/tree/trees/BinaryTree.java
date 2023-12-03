package com.swlo.tree.trees;

import com.swlo.tree.util.PrintEnum;
import com.swlo.tree.node.BinaryTreeNode;

import java.util.List;

public class BinaryTree<T extends Comparable<T>> extends GenericTree<T> {

    @Override
    public void add(T element) {
        if (getRoot() == null) {
            setRoot(new BinaryTreeNode<>(element));
            return;
        }

        BinaryTreeNode<T> current = getRoot();

        while (true) {
            if (element.compareTo(current.getElement()) < 0) {
                if (current.getLeftChild() == null) {
                    current.setLeftChild(new BinaryTreeNode<>(element, current));
                    break;
                } else {
                    current = current.getLeftChild();
                }
            }

            if (element.compareTo(current.getElement()) > 0) {
                if (current.getRightChild() == null) {
                    current.setRightChild(new BinaryTreeNode<>(element, current));
                    break;
                } else {
                    current = current.getRightChild();
                }
            }

            if (element.compareTo(current.getElement()) == 0) {
                break;
            }
        }
    }

    @Override
    public void remove(T element) {

        if (getRoot() == null) {
            return;
        }


        BinaryTreeNode<T> current = search(element);
        BinaryTreeNode<T> auxiliary = null;


        if (current.getLeftChild() == null && current.getRightChild() == null) {
            auxiliary = current.getParent();
            if (auxiliary.getLeftChild() == current) {
                auxiliary.setLeftChild(null);
            } else {
                auxiliary.setRightChild(null);
            }
        }

        if (current.getLeftChild() != null && current.getRightChild() == null) {
            auxiliary = current.getParent();
            if (auxiliary.getLeftChild() == current) {
                auxiliary.setLeftChild(current.getLeftChild());
                auxiliary.getLeftChild().setParent(auxiliary);
            } else {
                auxiliary.setRightChild(current.getLeftChild());
                auxiliary.getRightChild().setParent(auxiliary);
            }
        }

        if (current.getLeftChild() == null && current.getRightChild() != null) {
            auxiliary = current.getParent();
            if (auxiliary.getLeftChild() == current) {
                auxiliary.setLeftChild(current.getRightChild());
                auxiliary.getLeftChild().setParent(auxiliary);
            } else {
                auxiliary.setRightChild(current.getRightChild());
                auxiliary.getRightChild().setParent(auxiliary);
            }
        }

        if (current.getLeftChild() != null && current.getRightChild() != null) {
            auxiliary = current.getRightChild();
            while (auxiliary.getLeftChild() != null) {
                auxiliary = auxiliary.getLeftChild();
            }
            current.setElement(auxiliary.getElement());
            if (auxiliary.getRightChild() != null) {
                auxiliary.setElement(auxiliary.getRightChild().getElement());
                auxiliary.setRightChild(null);
            } else {
                auxiliary.setParent(auxiliary.getParent());
                auxiliary.getParent().setLeftChild(null);
            }

        }

    }

    @Override
    public BinaryTreeNode<T> search(T element) {

        if (getRoot() == null) {
            return null;
        }

        BinaryTreeNode<T> current = getRoot();

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

    @SuppressWarnings("unchecked")
    public List<T> getOrdered(PrintEnum type) {

        return (List<T>) type.getFunction().apply(getRoot());
    }



    public void balance() {
        BinaryTreeNode<T> pseudoRoot = new BinaryTreeNode<>(null);
        pseudoRoot.setRightChild(getRoot());

        treeToVine(pseudoRoot);
        vineToTree(pseudoRoot, size(pseudoRoot));

        setRoot(pseudoRoot.getRightChild());
    }

    private void treeToVine(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> tail = root;
        BinaryTreeNode<T> rest = tail.getRightChild();

        while (rest != null) {
            if (rest.getLeftChild() == null) {
                tail = rest;
                rest = rest.getRightChild();
            } else {
                BinaryTreeNode<T> temp = rest.getLeftChild();
                rest.setLeftChild(temp.getRightChild());
                temp.setRightChild(rest);
                rest = temp;
                tail.setRightChild(temp);
            }
        }
    }

    private void vineToTree(BinaryTreeNode<T> root, int size) {
        int leaves = size + 1 - (int) Math.pow(2, Math.floor(Math.log(size + 1) / Math.log(2)));
        makeRotations(root, leaves);

        size = size - leaves;
        while (size > 1) {
            makeRotations(root, size /= 2);
        }
    }

    private void makeRotations(BinaryTreeNode<T> root, int bound) {
        BinaryTreeNode<T> node = root;
        for (; bound > 0; bound--) {
            BinaryTreeNode<T> a = node;
            BinaryTreeNode<T> b = a.getRightChild();
            BinaryTreeNode<T> c = b.getRightChild();

            a.setRightChild(c);
            b.setRightChild(c.getLeftChild());
            c.setLeftChild(b);

            node = node.getRightChild();
        }
    }

    private int size(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.getLeftChild()) + size(node.getRightChild());
        }
    }

}




