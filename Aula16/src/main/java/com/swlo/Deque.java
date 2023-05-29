package com.swlo;

import java.util.LinkedList;
public class Deque<T> {
    private LinkedList<T> deque;

    public Deque(){
        deque = new LinkedList<>();
    }

    public void addFirst(T elemento){
        deque.addFirst(elemento);
    }

    public void addLast(T elemento){
        deque.addLast(elemento);
    }

    public T removeFirst(){
        return(deque.removeFirst());
    }

    public T removeLast(){
        return(deque.removeLast());
    }

    public T getFirst(){
        return(deque.getFirst());
    }

    public T getLast(){
        return(deque.getLast());
    }

    public boolean isEmpty(){
        return(deque.isEmpty());
    }

    public int size(){
        return(deque.size());
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Deque: ");
        for(T elementos : deque){
            stringBuilder.append(elementos);
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

}