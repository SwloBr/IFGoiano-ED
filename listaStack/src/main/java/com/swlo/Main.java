package com.swlo;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        String[] text = ("ESARF ATERCES ODALERAHCAB ME AICNEIC AD OAÇATUPMOC FI ONAIOG SUPMAC SOHNIRROM HE MU SOD SEROHLEM SOSRUC ED OAÇATUPMOC OD ODATSE ED SAIOG").split(" ");

        for (int i = 0; i < text.length; i++) {
            stack.push(text[i]);
        }


        Stack<String> reversedStack = new Stack<>();
        while (!stack.isEmpty()) {
            String str = stack.pop();
            String reversedStr = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                reversedStr += str.charAt(i);
            }
            reversedStack.push(reversedStr);
        }


        System.out.println("As strings invertidas são:");
        while (!reversedStack.isEmpty()) {
            System.out.print(reversedStack.pop() + " ");
        }
    }
}
