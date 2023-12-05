package com.swlo.tree;

import com.swlo.tree.trees.AvlTree;
import com.swlo.tree.util.ArchiveUtils;
import com.swlo.tree.util.PrintEnum1;

public class AvlMain {
    private static ArchiveUtils archiveUtils = new ArchiveUtils();

    public static void main(String[] args) {


        int[] unsortedArray = archiveUtils.readFile("C:\\ESD\\dados100_mil.txt");


        // Criação das threads
        Thread thread1 = new Thread(() -> {


            AvlTree<Integer> avlTree = new AvlTree<>();

            long initTimerTree = System.currentTimeMillis();

            for (int number : unsortedArray) {
                avlTree.add(number);
            }


            avlTree.getOrdered(PrintEnum1.INFIX);


            long closeTimerTree = System.currentTimeMillis();

            System.out.println("\n AVL TREE: " + timer(closeTimerTree - initTimerTree));


        });

        Thread thread2 = new Thread(() -> {


            int[] unsortedInsertionList = new int[unsortedArray.length];

            long initTimerSort = System.currentTimeMillis();

            for (int i = 0; i < unsortedArray.length; i++) {

                unsortedInsertionList[i] = unsortedArray[i];

            }

            sort(unsortedInsertionList);


            long closeTimerInsertionSort = System.currentTimeMillis();


            System.out.println("\n INSERTION SORT: " + timer(closeTimerInsertionSort - initTimerSort));




        });

        thread1.start();
        thread2.start();








        try {
            thread1.join();
            thread2.join();








        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static String timer(long executionTime) {
        int milliSeconds = (int) (executionTime % 1000);
        int seconds = (int) (executionTime / 1000) % 60;
        int minutes = (int) (executionTime / 1000) / 60;
        int hour = (int) (executionTime / 3600000);

        return String.format("%02d:%02d:%02d:%03d", hour, minutes, seconds, milliSeconds);

    }


    private static int[] sort(int[] array) {
        insertionSort(array);
        return array;
    }

    private static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }


}