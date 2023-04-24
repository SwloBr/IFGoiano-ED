package com.swlo.ex7;

import java.util.*;

public class Ex7 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 20; i++) {
            queue.add(i);
        }
        System.out.println("Original queue: " + queue);

        reverseQueue(queue);

        System.out.println("Reversed queue: " + queue);
    }

    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}

