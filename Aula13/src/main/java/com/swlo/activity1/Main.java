package com.swlo.activity1;


import com.swlo.DoubleLinkedList;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] numbers = generateRandomNumbers(1000, -9999, 9999); //criar a lista com 1k de numeros
        System.out.println("Vetor: " + Arrays.toString(numbers));

        DoubleLinkedList list = new DoubleLinkedList();
        for (int number : numbers) {
            list.insertSorted(number);
        }

        System.out.println("\n\n\n========\n\n\nLista em ordem crescente:");
        list.printCrescent();

        System.out.println("\n\n\n========\n\n\nLista em ordem decrescente:");
        list.printDecrescent();

        DoubleLinkedList listPrime = list.duplicateList();

        list.removePrimes();

        System.out.println("\n\n\n========\n\n\nLista sem números primos em ordem crescente:");
        list.printCrescent();

        System.out.println("\n\n\n========\n\n\nLista sem números primos em ordem decrescente:");
        list.printDecrescent();

        listPrime.removeNonPrimes();

        System.out.println("\n\n\n========\n\n\nLista somente números primos em ordem crescente:");
        listPrime.printCrescent();

        System.out.println("\n\n\n========\n\n\nLista somente números primos em ordem decrescente:");
        listPrime.printDecrescent();
    }

    public static int[] generateRandomNumbers(int count, int min, int max) {
        Random random = new Random();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextInt(max - min + 1) + min;
        }
        return numbers;
    }
}