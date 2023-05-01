package com.swlo;

import java.util.Scanner;

import static com.swlo.Converters.*;
import static com.swlo.Util.indentifyNotation;

public class Main implements Converters, Util {

    public static String operation;


    public static String infix, postfix, prefix;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a operação: ");

        operation = scanner.nextLine();

//        operation = ("( ( 4 + 5 ) * ( 6 / 3 ) )"); // Infix R: 18

//        operation = ("( 10 + ( ( 3 * 5 ) / ( 16 - 4 ) ) )"); // Infix R: 80
//        operation = ("10 3 5 * 16 4 - / +"); // Posfix R: 80
//        operation = ("+ 10 / * 3 5 - 16 4"); // Prefix R: 80

        scanner.close();


        switch (indentifyNotation(operation.trim())) {

            case 1:
                prefix = operation.trim();
                postfix = prefixToPostfix(prefix);
                infix = postfixToInfix(postfix);
                break;
            case 2:
                infix = operation.trim();
                postfix = infixToPostfix(infix);
                prefix = postfixToPrefix(postfix);
                break;
            case 3:
                postfix = operation.trim();
                prefix = postfixToPrefix(postfix);
                infix = postfixToInfix(postfix);
                break;
        }

        System.out.println("\n\nPre-fixa: " + prefix);
        System.out.println("infixa: " + infix);
        System.out.println("Pos-fixa: " + postfix);
        System.out.println("\nResultado: " + postfixResult(postfix));

    }

}
