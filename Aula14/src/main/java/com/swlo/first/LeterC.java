package com.swlo.first;

import com.swlo.DoubleLinkedList;

public class LeterC {
    public static void main(String[] args) {

        DoubleLinkedList list1 = new DoubleLinkedList();
        DoubleLinkedList list2 = new DoubleLinkedList();

        list1.add("a");
        list2.add("b");
        list1.add("c");
        list2.add("d");
        list1.add("e");
        list2.add("f");
        list1.add("g");
        list2.add("h");
        list1.add("i");

        DoubleLinkedList mergedList = list1.merge(list1, list2);

        System.out.println(mergedList);

    }
}
