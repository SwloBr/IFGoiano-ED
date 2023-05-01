package com.swlo;

import java.util.Objects;
import java.util.Stack;

import static com.swlo.Util.*;

public interface Converters {

    static String infixToPostfix(String operation) {

        String[] operate = operation.split(" ");

        Stack<String> operator = new Stack<>();

        StringBuilder postfix = new StringBuilder();

        for (String value : operate) {
            if (isOperator(value)) {

                while (!operator.isEmpty() && operatorPriority(value) <= operatorPriority(operator.peek())) {
                    postfix.append(operator.pop()).append(" ");
                }
                operator.push(value);

            } else if (Objects.equals(value, "(")) {
                operator.push(value);

            } else if (Objects.equals(value, ")")) {

                while (!operator.isEmpty() && !Objects.equals(operator.peek(), "(")) {
                    postfix.append(operator.pop()).append(" ");
                }
                operator.pop(); // para não entrar o " ( "

            } else {
                postfix.append(value).append(" ");
            }
        }
        while (!(operator.isEmpty())) {
            postfix.append(operator.pop()).append(" ");
        }

        return postfix.toString().trim();

    }

    static String postfixToInfix(String operation) {
        String[] operate = operation.split(" ");

        Stack<String> numbers = new Stack<>();


        for (String value : operate) {
            if (!isOperator(value)) {
                numbers.push(value);
            } else {
                String secondNumber = numbers.pop();
                String firstNumber = numbers.pop();
                numbers.push("(" + firstNumber + " " + value + " " + secondNumber + ")");
            }
        }

        return numbers.pop().trim();
    }

    static String postfixToPrefix(String operation) {
        Stack<String> numbers = new Stack<>();

        String[] operate = operation.split(" ");

        for (String value : operate) {
            if (!isOperator(value)) {
                numbers.push(value);
            } else {
                String secondNumber = numbers.pop();
                String firstNumber = numbers.pop();
                numbers.push(" " + value + " " + firstNumber + " " + secondNumber);
            }
        }
        return numbers.pop().replace("  ", " ").trim();
    }


    static String prefixToPostfix(String operation) {
        Stack<String> number = new Stack<>();
        String[] operate = operation.split(" ");

        for (int i = operate.length - 1; i >= 0; i--) {

            String value = operate[i];

            if (isOperator(value)) {
                String firstNumber = number.pop();
                String secondNumber = number.pop();
                number.push(firstNumber + " " + secondNumber + " " + value);
            } else {
                number.push(value);
            }
        }

        return number.pop().trim();
    }


    static Double postfixResult(String operation) {
        String[] operate = operation.split(" ");
        Stack<Double> numbers = new Stack<>();

        for (String value : operate) {
            if (!isOperator(value)) {
                numbers.push(Double.parseDouble(value));
            } else {
                double secondNumber = numbers.pop();
                double firstNumber = numbers.pop();
                switch (value) {

                    case "*":
                        numbers.push(firstNumber + secondNumber);
                        break;
                    case "/":
                        numbers.push(firstNumber + secondNumber);
                        break;
                    case "+":
                        numbers.push(firstNumber + secondNumber);
                        break;
                    case "-":
                        numbers.push(firstNumber + secondNumber);
                        break;
                    default:
                        System.out.println("Erro ao calcular");
                }
                numbers.push(firstNumber + secondNumber);
            }
        }
        return numbers.pop();
    }


}
