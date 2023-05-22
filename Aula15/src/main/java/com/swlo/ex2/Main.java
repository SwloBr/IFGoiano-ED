package com.swlo.ex2;

import java.util.Random;
import com.swlo.Stack;

public class Main {


    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();
    private static Stack<Integer> stack3 = new Stack<>();

    public static void main(String[] args) {

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int randomNumber = random.nextInt(9) + 1;

            if (randomNumber <= 3) {
                stack1.push(randomNumber);
            } else if (randomNumber <= 6) {
                stack2.push(randomNumber);
            } else {
                stack3.push(randomNumber);
            }
        }

        for (int i = 0; i < 100; i++) {
            int randomPile = random.nextInt(3) + 1;

            System.out.print("Empilhando os números ");

            if (randomPile == 1) {
                if (!stack1.isEmpty()) {
                    System.out.print(stack1.pop() + " ");
                } else {
                    System.out.println("Pilha 1 está vazia!");
                }
            } else if (randomPile == 2) {
                if (!stack2.isEmpty()) {
                    System.out.print(stack2.pop() + " ");
                } else {
                    System.out.println("Pilha 2 está vazia!");
                }
            } else {
                if (!stack3.isEmpty()) {
                    System.out.print(stack3.pop() + " ");
                } else {
                    System.out.println("Pilha 3 está vazia!");
                }
            }

            System.out.print("na pilha " + randomPile + "\n");

            if (stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()) {
                System.out.println("Pilha(s) vazia: " + returnEmptyStack());
                break;
            }
        }

        System.out.println("\nPilha 1: " + stack1.toString());
        System.out.println("Pilha 2: " + stack2.toString());
        System.out.println("Pilha 3: " + stack3.toString());
    }

    private static String returnEmptyStack() {
        StringBuilder stringBuilder = new StringBuilder();

        if (stack1.isEmpty()) {
            stringBuilder.append("1 ");
        }
        if (stack2.isEmpty()) {
            stringBuilder.append("2 ");
        }
        if (stack3.isEmpty()) {
            stringBuilder.append("3 ");
        }


        return stringBuilder.toString();

    }
}
