package com.swlo;

import java.util.Objects;

public interface Util {

    public static int operatorPriority(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    public static int indentifyNotation(String expression) {

        String[] exp = expression.split(" ");

        if (isOperator(exp[0])) {  //pre fixa
            return 1;

        } else if (expression.contains("(") || !(isOperator(exp[0])) && (isOperator(exp[1])) && !(isOperator(exp[2]))) { // infixa
            return 2;
        } else { // posfixa
            return 3;
        }
    }

    public static boolean isOperator(String operator) {
        return Objects.equals(operator, "+") || Objects.equals(operator, "-") || Objects.equals(operator, "*") || Objects.equals(operator, "/");
    }


}
