package com.swlo.second;

import com.swlo.DoubleLinkedList;

public class Main {

    /*

    Criei um metodo chamado remapHead(DoubleLinkedList), no qual ele,percorre
    a lista remapeando as Head de cada elemento da lista, ele Também é utilizado
    sempre em metodos que altera a lista de algum modo que pode desordenar as heads

     */

    public static void main(String[] args) {

        DoubleLinkedList list = new DoubleLinkedList();

        list.remapHead(list); //O metodo descrito acima.
    }
}
