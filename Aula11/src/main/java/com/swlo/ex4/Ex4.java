package com.swlo.ex4;

import java.util.*;

public class Ex4 {
    public static Queue<Integer> invertQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        Queue<Integer> invertedQueue = new LinkedList<>();
        while (!stack.isEmpty()) {
            invertedQueue.add(stack.pop());
        }
        return invertedQueue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 100; i++) {
            queue.add(i);
        }
        Queue<Integer> invertedQueue = invertQueue(queue);
        System.out.println("Original Queue: " + queue);
        System.out.println("Inverted Queue: " + invertedQueue);
    }
}
