package com.swlo;

import java.util.*;

public class Main {

    private static final LinkedList<String> soldiers = new LinkedList<>(Arrays.asList("Pedro", "Davi", "João", "Beltras", "Bruno", "Vitor", "Guilherme", "Enzo", "Samuel", "Carlos", "Alfredo", "Augusto", "Gabriel", "Rhennan", "Caua", "Wisley", "Julio", "Yuri", "Arthur", "Nicolas"));
    private static final int target = getRandomNumber(1, 30);

    public static void main(String[] args) {
        System.out.println("O numero escolhi como alvo foi o " + target);
        ListIterator<String> soldiresIterator = soldiers.listIterator();

        while (soldiers.size() > 1) {
            for (int i = 0; i < target; i++) {
                if (!soldiresIterator.hasNext()) {
                    soldiresIterator = soldiers.listIterator();
                }
                soldiresIterator.next();
            }
            soldiresIterator.remove();
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