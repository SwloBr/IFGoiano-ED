package com.swlo.ex1;

import java.util.Scanner;

import static com.swlo.ex1.Util.checkParenthesis;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Expressão: ");
        String expression = scanner.nextLine();

        if (checkParenthesis(expression)) {
            System.out.println("A expressão está correta.");
        } else {
            System.out.println("A expressão está incorreta.");
        }
    }
}
