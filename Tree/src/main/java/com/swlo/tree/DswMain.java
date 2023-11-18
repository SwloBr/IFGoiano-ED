package com.swlo.tree;

import com.swlo.tree.trees.BinaryTree;
import com.swlo.tree.util.PrintEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DswMain {


    private static Random random = new Random();

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Integer number = random.nextInt(0, 100);
            if (list.contains(number)) {
                i--;
            } else {
                list.add(number);
                tree.add(number);
            }
        }


        System.out.println("\nArvoré não balanceada com 100 elementos");
        System.out.println(tree.getOrdered(PrintEnum.LEVEL));


        tree.balance();

        System.out.println("\nArvoré  balanceada com 100 elementos");
        System.out.println(tree.getOrdered(PrintEnum.LEVEL));


        for (int i = 0; i < 20; i++) {
            Integer number = random.nextInt(0, 200);
            if (list.contains(number)) {
                i--;
            } else {
                list.add(number);
                tree.add(number);
            }
        }


        System.out.println("\nArvoré  com 100 elementos balanceados + 20 elementos não balanceados");
        System.out.println(tree.getOrdered(PrintEnum.LEVEL));

        tree.balance();

        System.out.println("\nArvoré balanceada com 120 elementos");
        System.out.println(tree.getOrdered(PrintEnum.LEVEL));


    }
}
