package com.swlo.ex1;

import com.swlo.Stack;

public class Util {


    public static boolean checkParenthesis(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else if (character == ')' || character == ']' || character == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((character == ')' && top != '(') || (character == ']' && top != '[')
                        || (character == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
