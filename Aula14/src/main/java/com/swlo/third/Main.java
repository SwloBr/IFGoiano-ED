package com.swlo.third;

import com.swlo.DoubleLinkedList;

public class Main {


    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        DoubleLinkedList list1 = new DoubleLinkedList();
        DoubleLinkedList list2 = new DoubleLinkedList();

        int quantity = list.countElementsQuantity(); // Letra A
        list.addFirst("Letra B"); // Letra B
        list.unify(list1, list2); // Letra C
        list.merge(list1, list2); // Letra D
        DoubleLinkedList newList = list.duplicate(); // Letra E
    }
}
