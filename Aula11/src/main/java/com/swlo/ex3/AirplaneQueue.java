package com.swlo.ex3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class AirplaneQueue implements Iterable<Airplane> {
    private Queue<Airplane> queue = new LinkedList<>();

    public void enqueue(Airplane airplane) {
        queue.offer(airplane);
    }

    public Airplane dequeue() {
        return queue.poll();
    }

    public Airplane peek() {
        return queue.peek();
    }

    public int getSize() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public Iterator<Airplane> iterator() {
        return queue.iterator();
    }
}
