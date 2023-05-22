package com.swlo.first;

import com.swlo.DoubleLinkedList;

public class LeterB {
    public static void main(String[] args) {
        DoubleLinkedList originalList = new DoubleLinkedList();

        DoubleLinkedList list1 = new DoubleLinkedList();
        DoubleLinkedList list2 = new DoubleLinkedList();

        originalList.add("a");
        originalList.add("b");
        originalList.add("c");
        originalList.add("d");
        originalList.add("e");
        originalList.add("f");
        originalList.add("g");
        originalList.add("h");
        originalList.add("i");

        originalList.split(4, list1, list2);

        System.out.print(list1 + "\n" + list2);

    }
}
