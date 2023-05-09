package com.swlo;

import java.awt.dnd.DragSourceDragEvent;
import java.util.Scanner;

public class Main {
    private static long moves = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de discos: ");
        int discs = scanner.nextInt();
        System.out.println();
        scanner.close();

        long startTime = System.nanoTime();
        HanaoiTower(discs, "Pino 1", "Pino 2", "Pino 3");
        long stopTime = System.nanoTime();
        long resultTime = stopTime - startTime;

        String formattedTime = formatTime(resultTime);
        System.out.println("\nTempo de execução: " + formattedTime);
        System.out.println("Número de movimentos: " + moves);
    }

    private static void HanaoiTower(int n, String origin, String destiny, String intermediary) {
        if (n == 1) {
            moves++;
            return;
        }
        HanaoiTower(n - 1, origin, intermediary, destiny);
        moves++;
        HanaoiTower(n - 1, intermediary, destiny, origin);
    }

    private static String formatTime(long nanoseconds) {
        long hours = nanoseconds / 3600000000000L;
        nanoseconds = nanoseconds % 3600000000000L;
        long minutes = nanoseconds / 60000000000L;
        nanoseconds = nanoseconds % 60000000000L;
        long seconds = nanoseconds / 1000000000L;
        nanoseconds = nanoseconds % 1000000000L;
        long millis = nanoseconds / 1000000L;

        return String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, millis);
    }
}