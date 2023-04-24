package com.swlo.ex8;

import java.util.*;

public class Ex8 {
    private Stack<Integer> N;
    private Stack<Integer> P;

    public Ex8() {
        N = new Stack<>();
        P = new Stack<>();
    }

    public void sortAndPrint() {
        Random rand = new Random();

        for (int i = 0; i < 1000; i++) {
            int num = rand.nextInt(201) - 100;

            if (num > 0) {
                P.push(num);
            } else if (num < 0) {
                N.push(num);
            } else {
                if (!N.isEmpty() && !P.isEmpty()) {
                    System.out.println("Negative: " + N.pop() + " Positive: " + P.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        Ex8 tp = new Ex8();
        tp.sortAndPrint();
    }
}
