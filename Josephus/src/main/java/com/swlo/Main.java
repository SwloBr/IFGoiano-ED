package com.swlo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    private static final ArrayList<String> soldiers = new ArrayList<>(Arrays.asList("Pedro", "Davi", "João", "Beltras", "Bruno", "Vitor", "Guilherme", "Enzo", "Samuel", "Carlos", "Alfredo", "Augusto", "Gabriel", "Rhennan", "Caua", "Wisley", "Julio", "Yuri", "Arthur", "Nicolas"));


    public static void main(String[] args) {
        for (int i = 19; i != 0; i--) {

            System.out.println(soldiers.remove(getRandomNumber(0, i + 1)) + " foi removido.");

        }


        revealWinner(soldiers.get(0));
    }

    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    private static void revealWinner(String result) {

        for (int i = 0; i < result.length() + 20; i++) {
            System.out.print("#");

        }

        System.out.print("\n# " + result + " foi o escolhido #\n");

        for (int i = 0; i < result.length() + 20; i++) {
            System.out.print("#");

        }
    }
}