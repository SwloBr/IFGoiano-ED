package com.swlo.tree.util;

import com.swlo.tree.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public enum PrintEnum {
    PREFIX((node) -> print(node, Order.PREFIX)),
    INFIX((node) -> print(node, Order.INFIX)),
    POSTFIX((node) -> print(node, Order.POSTFIX)),
    LEVEL((node) -> print(node, Order.LEVEL));

    private final TreeFunction function;

    PrintEnum(TreeFunction function) {
        this.function = function;
    }

    private static <T extends Comparable<T>> List<T> print(TreeNode<T> node, Order order) {
        List<T> list = new ArrayList<>();
        switch (order) {
            case PREFIX:
                if (node != null) {
                    list.add(node.getElement());
                    list.addAll(print(node.getLeftChild(), order));
                    list.addAll(print(node.getRightChild(), order));
                }
                break;
            case INFIX:
                if (node != null) {
                    list.addAll(print(node.getLeftChild(), order));
                    list.add(node.getElement());
                    list.addAll(print(node.getRightChild(), order));
                }
                break;
            case POSTFIX:
                if (node != null) {
                    list.addAll(print(node.getLeftChild(), order));
                    list.addAll(print(node.getRightChild(), order));
                    list.add(node.getElement());
                }
                break;
            case LEVEL:
                Queue<TreeNode<T>> queue = new LinkedList<>();
                queue.add(node);
                while (!queue.isEmpty()) {
                    TreeNode<T> currentNode = queue.poll();
                    list.add(currentNode.getElement());
                    if (currentNode.getLeftChild() != null) queue.add(currentNode.getLeftChild());
                    if (currentNode.getRightChild() != null) queue.add(currentNode.getRightChild());
                }
                break;
        }
        return list;
    }

    public TreeFunction getFunction() {
        return function;
    }

    enum Order {
        PREFIX, INFIX, POSTFIX, LEVEL
    }

    public interface TreeFunction<T extends Comparable<T>> {
        List<T> apply(TreeNode<T> tree);
    }
}