package com.swlo.tree;

import com.swlo.tree.trees.AvlTree;
import com.swlo.tree.trees.RedBlackTree;
import com.swlo.tree.util.ArchiveUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LastMain {
    private static final ArchiveUtils archiveUtils = new ArchiveUtils();

    public static void main(String[] args) {


        int[] unsortedArray = archiveUtils.readFile("C:\\ESD\\dados100_mil.txt");


        AvlTree<Integer> avlTree = new AvlTree<>();

        // Criação das threads
        Thread thread1 = new Thread(() -> {


            long initTimerTree = System.currentTimeMillis();

            for (int number : unsortedArray) {
                avlTree.add(number);
            }


//            avlTree.getOrdered(PrintEnum1.INFIX);


            long closeTimerTree = System.currentTimeMillis();

            System.out.println("\n AVL TREE: " + timer(closeTimerTree - initTimerTree));


        });

        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();

        Thread thread2 = new Thread(() -> {


            long initTimerTree = System.currentTimeMillis();

            for (int number : unsortedArray) {
                redBlackTree.add(number);
            }


//            redBlackTree.getOrdered(PrintEnum2.INFIX);


            long closeTimerTree = System.currentTimeMillis();

            System.out.println("\n RED BLACK TREE: " + timer(closeTimerTree - initTimerTree));

        });

        thread1.start();
        thread2.start();


        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50000; i++) {
            int number = random.nextInt(19999) - 9999; // Generate a random number between -9999 and 9999
            list.add(number);
        }


        System.out.println("Tempo de inserrção");



        try {
            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tempo");
        Thread thread3 = new Thread(() -> {
            int countAvl = 0;

            long initTimerTree = System.currentTimeMillis();

            for (int number : list) {
                if (number % 3 == 0) {
                    // If the number is a multiple of 3, insert it into the AVL tree
                    avlTree.add(number);
                } else if (number % 5 == 0) {
                    // If the number is a multiple of 5, remove it from the AVL tree
                    avlTree.remove(number);
                } else {
                    // If the number is not a multiple of 3 or 5, count how many times it appears in the AVL tree
                    if (avlTree.search(number) != null) {
                        countAvl++;
                    }
                }
            }

            long closeTimerTree = System.currentTimeMillis();


            System.out.println("\nAVL TREE: " + timer(closeTimerTree - initTimerTree) + "\nNumeros contados:  " + countAvl);

        });

        Thread thread4 = new Thread(() -> {
            int countRedBlack = 0;

            long initTimerTree = System.currentTimeMillis();

            for (int number : list) {
                if (number % 3 == 0) {
                    // If the number is a multiple of 3, insert it into the Red-Black tree
                    redBlackTree.add(number);
                } else if (number % 5 == 0) {
                    // If the number is a multiple of 5, remove it from the Red-Black tree
                    redBlackTree.remove(number);
                } else {
                    // If the number is not a multiple of 3 or 5, count how many times it appears in the Red-Black tree
                    if (redBlackTree.search(number) != null) {
                        countRedBlack++;
                    }
                }
            }


            long closeTimerTree = System.currentTimeMillis();

            System.out.println("\nRED BLACK TREE: " + timer(closeTimerTree - initTimerTree) + "\nNumeros contados:  " + countRedBlack);

        });

        thread3.start();
        thread4.start();


    }


    private static String timer(long executionTime) {
        int milliSeconds = (int) (executionTime % 1000);
        int seconds = (int) (executionTime / 1000) % 60;
        int minutes = (int) (executionTime / 1000) / 60;
        int hour = (int) (executionTime / 3600000);

        return String.format("%02d:%02d:%02d:%03d", hour, minutes, seconds, milliSeconds);

    }


}