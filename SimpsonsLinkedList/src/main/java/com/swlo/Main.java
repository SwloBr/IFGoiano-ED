package com.swlo;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList lista = new DoubleLinkedList();

        // Problema 1
        System.out.println("\nProblema 1");
        lista.add("Homer");
        lista.add("Marge");
        System.out.println(lista); // [Homer, Marge]

        // Problema 2
        System.out.println("\nProblema 2");
        lista.clearList();
        System.out.println(lista); // []

        // Problema 3
        System.out.println("\nProblema 3");
        lista.add("Homer");
        lista.add(0, "Bart");
        lista.add(1, "Moll");
        System.out.println(lista); // [Bart, Moll, Homer]

        // Problema 4
        System.out.println("\nProblema 4");
        lista.clearList();
        System.out.println(lista); // []

        // Problema 5
        System.out.println("\nProblema 5");
        lista.add("Homer");
        lista.add("Bart");
        lista.add("Marge");
        lista.remove(1);
        System.out.println(lista); // [Homer, Marge]

        // Problema 6
        System.out.println("\nProblema 6");
        lista.clearList();
        System.out.println(lista); // []

        // Problema 7
        System.out.println("\nProblema 7");
        lista.add("Homer");
        lista.add("Maggie");
        lista.add(0, "Bart");
        lista.add(1, "Marge");
        System.out.println(lista); // [Bart, Marge, Homer, Maggie]
        System.out.println("Lisa está na lista: " + lista.contains("Lisa")); // false

        // Problema 8
        System.out.println("\nProblema 8");
        lista.clearList();
        System.out.println(lista); // []

        // Problema 9
        System.out.println("\nProblema 9");
        lista.add("Homer");
        lista.add("Bart");
        System.out.println(lista); // [Homer, Bart]
        System.out.println("Tamanho da lista: " + lista.size()); // 2

        // Problema 10
        System.out.println("\nProblema 10");
        lista.clearList();
        lista.add("Homer");
        lista.add("Bart");
        lista.add("Marge");
        lista.add("Maggie");
        System.out.println("Marge está na lista: " + lista.contains("Marge")); // true
        System.out.println("Homer está na lista: " + lista.contains("Homer")); // true
        System.out.println("Bart está na lista: " + lista.contains("Bart")); // true
        System.out.println("Maggie está na lista: " + lista.contains("Maggie")); // true
        System.out.println("Tamanho da lista: " + lista.size()); // 4

        // Problema 11
        System.out.println("\nProblema 11");
        lista.clearList();
        System.out.println(lista); // []

        // Problema 12
        System.out.println("\nProblema 12");
        lista.addFirst("Homer");
        lista.addFirst("Bart");
        lista.add(1, "Marge");
        lista.add(2, "Maggie");
        lista.addFirst("Ned Flanders");
        lista.addLast("Sr. Burns");
        System.out.println(lista); // [Ned Flanders, Bart, Marge, Maggie, Homer, Sr. Burns]

        // Problema 13
        System.out.println("\nProblema 13");
        lista.removeLast();
        System.out.println(lista); // [Ned Flanders, Bart, Marge, Maggie, Homer]

        // Problema 14
        System.out.println("\nProblema 14");
        lista.remove(1);
        System.out.println(lista); // [Ned Flanders, Marge, Maggie, Homer]
        System.out.println("Tamanho da lista: " + lista.size()); // 4

        // Problema 15
        System.out.println("\nProblema 15");
        System.out.println("Marge está na lista: " + lista.contains("Marge")); // true
        System.out.println("Homer está na lista: " + lista.contains("Homer")); // true
        System.out.println("Bart está na lista: " + lista.contains("Bart")); // false
        System.out.println("Maggie está na lista: " + lista.contains("Maggie")); // true
        System.out.println("Tamanho da lista: " + lista.size()); // 4

        // Problema 16
        System.out.println("\nProblema 16");
        lista.removeFirst();
        System.out.println(lista); // [Marge, Maggie, Homer]
        System.out.println("Tamanho da lista: " + lista.size()); // 3

        // Problema 17
        System.out.println("\nProblema 17");
        lista.clearList();
        lista.add("Homer");
        lista.add("Bart");
        lista.add("Marge");
        lista.add("Maggie");
        System.out.println("Marge está na lista: " + lista.contains("Marge")); // true
        System.out.println("Homer está na lista: " + lista.contains("Homer")); // true
        System.out.println("Bart está na lista: " + lista.contains("Bart")); // true
        System.out.println("Maggie está na lista: " + lista.contains("Maggie")); // true
        System.out.println("Tamanho da lista: " + lista.size()); // 4

        // Problema 18
        System.out.println("\nProblema 18");
        lista.clearList();
        System.out.println(lista); // []
    }



}