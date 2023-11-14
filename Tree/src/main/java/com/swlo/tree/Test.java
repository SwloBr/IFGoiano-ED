package com.swlo.tree;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Test {

    private static Random random = new Random();

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();


        for (int i = 0; i < 100; i++) {
            tree.add(random.nextInt(0, 20));
        }

        List<?> fd = tree.getOrdered(PrintEnum.PREFIX);

        List<Object> gdd = Collections.singletonList(tree.getOrdered(PrintEnum.PREFIX));

        if (gdd.get(0) instanceof Integer) {
            System.out.println(" SIMMMMMM");
        } else {
            System.out.println("Não");
        }







        System.out.println(tree.getOrdered(PrintEnum.PREFIX));
        System.out.println(tree.getOrdered(PrintEnum.INFIX));
        System.out.println(tree.getOrdered(PrintEnum.POSTFIX));
        System.out.println(tree.getOrdered(PrintEnum.LEVEL));



        BinaryTree<String> tree2 = new BinaryTree<>();

        tree2.add("Pedro Paulo");
        tree2.add("Bruno");
        tree2.add("Matheus");
        tree2.add("Batat");
        tree2.add("Pedro Naves");
        tree2.add("Jesmmer");
        tree2.add("Fernnado");
        tree2.add("Kefera");
        tree2.add("Abilio");


        System.out.println(tree2.getOrdered(PrintEnum.PREFIX));
        System.out.println(tree2.getOrdered(PrintEnum.INFIX));
        System.out.println(tree2.getOrdered(PrintEnum.POSTFIX));


    }

}
