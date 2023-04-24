package com.swlo.ex5;

import java.util.*;

public class Ex5 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        Set<Integer> set = new HashSet<>();
        Random rand = new Random();

        for (int i = 0; i < 1000; i++) {
            int num = rand.nextInt(700);
            if (!set.contains(num)) {
                set.add(num);
                queue.add(num);
            } else {
                stack.push(num);
            }
        }

        System.out.println("Queue F:");
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println("\n");

        System.out.println("Stack P:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("\n");
    }
}
