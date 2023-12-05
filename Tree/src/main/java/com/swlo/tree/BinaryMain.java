package com.swlo.tree;

import com.swlo.tree.trees.BinaryTree;
import com.swlo.tree.util.PrintEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinaryMain {

    private static Random random = new Random();

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Integer number = random.nextInt(0, 100);
            if (list.contains(number)) {
                i--;
                continue;
            } else {
                list.add(number);
                tree.add(number);
            }
        }

        System.out.println("\n\nPRIMEIRA ARVORE:");

        System.out.println(tree.getOrdered(PrintEnum.PREFIX));
        System.out.println(tree.getOrdered(PrintEnum.INFIX));
        System.out.println(tree.getOrdered(PrintEnum.POSTFIX));
        System.out.println(tree.getOrdered(PrintEnum.LEVEL));


        BinaryTree<Integer> tree2 = new BinaryTree<>();


        tree2.add(list.get(19));
        tree2.add(list.get(18));
        tree2.add(list.get(17));
        tree2.add(list.get(16));
        tree2.add(list.get(15));


        tree.remove(list.get(19));
        tree.remove(list.get(18));
        tree.remove(list.get(17));
        tree.remove(list.get(16));
        tree.remove(list.get(15));

        System.out.println("\n\nPRIMEIRA ARVORE -5 ELEMENTOS:");

        System.out.println(tree.getOrdered(PrintEnum.PREFIX));
        System.out.println(tree.getOrdered(PrintEnum.INFIX));
        System.out.println(tree.getOrdered(PrintEnum.POSTFIX));
        System.out.println(tree.getOrdered(PrintEnum.LEVEL));

        System.out.println("\n\nSEGUNDA ARVORE :");

        System.out.println(tree2.getOrdered(PrintEnum.PREFIX));
        System.out.println(tree2.getOrdered(PrintEnum.INFIX));
        System.out.println(tree2.getOrdered(PrintEnum.POSTFIX));
        System.out.println(tree2.getOrdered(PrintEnum.LEVEL));


        BinaryTree<String> tree3 = new BinaryTree<>();

        tree3.add("Pedro Paulo");
        tree3.add("Bruno");
        tree3.add("Matheus");
        tree3.add("Batat");
        tree3.add("Pedro Naves");
        tree3.add("Jesmmer");
        tree3.add("Fernnado");
        tree3.add("Kefera");
        tree3.add("Abilio");


        System.out.println("\n\nBONUS ARVORE (Demostração do tipo generico funcionando) :");

        System.out.println(tree3.getOrdered(PrintEnum.PREFIX));
        System.out.println(tree3.getOrdered(PrintEnum.INFIX));
        System.out.println(tree3.getOrdered(PrintEnum.POSTFIX));
        System.out.println(tree3.getOrdered(PrintEnum.LEVEL));


    }

}
