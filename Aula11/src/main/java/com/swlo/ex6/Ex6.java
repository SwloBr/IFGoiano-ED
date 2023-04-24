package com.swlo.ex6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Ex6 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        Random rand = new Random();

        for (int i = 0; i < 1000; i++) {
            int positive = rand.nextInt(1500) + 1;
            int negative = -rand.nextInt(1500) - 1;
            queue.add(positive);
            queue.add(negative);
        }

        while (!queue.isEmpty()) {
            int num = queue.remove();
            if (num > 0) {
                stack.push(num);
            } else {
                if (!stack.isEmpty()) {
                    System.out.println("Value: " + stack.pop());
                }
            }
        }
    }
}
