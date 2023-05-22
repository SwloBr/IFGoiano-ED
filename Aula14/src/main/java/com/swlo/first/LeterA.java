package com.swlo.first;

import com.swlo.DoubleLinkedList;

public class LeterA  {

    public static void main(String[] args) {
        DoubleLinkedList list1 = new DoubleLinkedList();
        DoubleLinkedList list2 = new DoubleLinkedList();

        list1.add("Marge");
        list1.add("Megge");
        list1.add("Homer");
        list1.add("Bart");
        list1.add("Lisa");

        list2.add("Sr. Burns");
        list2.add("Caul");
        list2.add("Lu");
        list2.add("Moe");
        list2.add("Skinner");


        list1.unify(list1, list2);

        System.out.println(list1);
    }


}
