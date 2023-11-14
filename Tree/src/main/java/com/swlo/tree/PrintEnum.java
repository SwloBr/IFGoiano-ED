package com.swlo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public enum PrintEnum {
    PREFIX("PREFIX", (node) -> {

        List<Object> list = new ArrayList<>();
        printPrefix(node, list);

        return list;
    }),
    INFIX("INFIX", (node) -> {

        List<Object> list = new ArrayList<>();
        printInfix(node, list);

        return list;

    }),
    POSTFIX("POSTFIX", (node) -> {

        List<Object> list = new ArrayList<>();
        printPostfix(node, list);

        return list;


    }),
    LEVEL("LEVEL", (node) -> {

        List<Object> list = new ArrayList<>();
        printLeveled(node, list);

        return list;

    });

    private final String name;
    private final TreeFunction function;

    <T extends Comparable<T>> PrintEnum(String name, TreeFunction<T> function) {
        this.name = name;
        this.function = function;
    }

    private static <T extends Comparable<T>> void printPrefix(TreeNode<T> node, List<Object> list) {
        if (node == null) {
            return;
        }

        list.add(node.getElement().toString());
//        System.out.println(node.getElement());
        printPrefix(node.getLeftChild(), list);
        printPrefix(node.getRightChild(), list);
    }

    private static <T extends Comparable<T>> void printInfix(TreeNode<T> node, List<Object> list) {
        if (node == null) {
            return;
        }
        printInfix(node.getLeftChild(), list);
        list.add(node.getElement().toString());
//        System.out.println(node.getElement());
        printInfix(node.getRightChild(), list);
    }

    private static <T extends Comparable<T>> void printPostfix(TreeNode<T> node, List<Object> list) {
        if (node == null) {
            return;
        }
        printPostfix(node.getLeftChild(), list);
        printPostfix(node.getRightChild(), list);
        list.add(node.getElement().toString());
    }

    private static <T extends Comparable<T>> void printLeveled(TreeNode<T> node, List<Object> list) {
        if (node == null) {
            return;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode<T> currentNode = queue.poll();
            list.add(currentNode.getElement());

            if (currentNode.getLeftChild() != null) {
                queue.add(currentNode.getLeftChild());
            }
            if (currentNode.getRightChild() != null) {
                queue.add(currentNode.getRightChild());
            }
        }


    }

    public String getName() {
        return name;
    }

    public TreeFunction getFunction() {
        return function;
    }


    interface TreeFunction<T extends Comparable<T>> {
        List<Object> apply(TreeNode<T> tree);
    }
}
