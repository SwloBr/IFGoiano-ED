package com.swlo.tree;

import java.util.List;

public class BinaryTree<T extends Comparable<T>> extends GenericTree<T> {

    @Override
    public void add(T element) {
        if (getRoot() == null) {
            setRoot(new TreeNode<>(element));
            return;
        }

        TreeNode<T> current = getRoot();


        if (element.compareTo(current.getElement()) < 0) {
            if (current.getLeftChild() == null) {
                current.setLeftChild(new TreeNode<>(element, current));
            } else {
                current = current.getLeftChild();
            }
        }

        if (element.compareTo(current.getElement()) > 0) {
            if (current.getRightChild() == null) {
                current.setRightChild(new TreeNode<>(element, current));
            } else {
                current = current.getRightChild();
            }
        }

        if (element.compareTo(current.getElement()) == 0) {
            return;
        }
    }

    @Override
    public void remove(T element) {

        if (getRoot() == null) {
            return;
        }


        TreeNode<T> current = search(element);
        TreeNode<T> auxiliary = null;


        if (current.getLeftChild() == null && current.getRightChild() == null) {
            auxiliary = current.getDad();
            if (auxiliary.getLeftChild() == current) {
                auxiliary.setLeftChild(null);
            } else {
                auxiliary.setRightChild(null);
            }
        }

        if (current.getLeftChild() != null && current.getRightChild() == null) {
            auxiliary = current.getDad();
            if (auxiliary.getLeftChild() == current) {
                auxiliary.setLeftChild(current.getLeftChild());
                auxiliary.getLeftChild().setDad(auxiliary);
            } else {
                auxiliary.setRightChild(current.getLeftChild());
                auxiliary.getRightChild().setDad(auxiliary);
            }
        }

        if (current.getLeftChild() == null && current.getRightChild() != null) {
            auxiliary = current.getDad();
            if (auxiliary.getLeftChild() == current) {
                auxiliary.setLeftChild(current.getRightChild());
                auxiliary.getLeftChild().setDad(auxiliary);
            } else {
                auxiliary.setRightChild(current.getRightChild());
                auxiliary.getRightChild().setDad(auxiliary);
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
                auxiliary.setDad(auxiliary.getDad());
                auxiliary.getDad().setLeftChild(null);
            }

        }

    }

    @Override
    public TreeNode<T> search(T element) {

        if (getRoot() == null) {
            return null;
        }

        TreeNode<T> current = getRoot();

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

    public List<String> print(PrintEnum printEnum) {

        return printEnum.getFunction().apply(getRoot());


    }




}
