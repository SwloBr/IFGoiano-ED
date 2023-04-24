package com.swlo.ex2;

import com.swlo.Stack;

public class Ex2 {
    public static Stack<String> mainStack = new Stack<>(false);
    public static Stack<String> otherStack = new Stack<>(false);

    public static void main(String[] args) {

        mainStack.push("A");
        mainStack.push("B");
        mainStack.push("C");
        mainStack.push("D");
        mainStack.push("E");
        mainStack.push("F");
        mainStack.push("G");
        mainStack.push("H");
        mainStack.push("I");
        removeElement(5);

        for (int i = 0; i < mainStack.getLength(); i++) {

            System.out.println(mainStack.pop());
        }
    }

    private static void removeElement(int position) {

        if (position < 0 || position > mainStack.getLength()) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 0) {
            mainStack.pop();
            return;
        }
        if (position > 0) {
            for (int i = 0; i < position-1; i++) {
                otherStack.push(mainStack.pop());
            }
            mainStack.pop();
            for (int i = 0; i < position-1; i++) {
                mainStack.push(otherStack.pop());
            }
        }


    }
}
