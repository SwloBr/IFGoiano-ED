package com.swlo.activity2;

import com.swlo.Cell;
import com.swlo.DoubleLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Random random = new Random();
    private static final DoubleLinkedList list = new DoubleLinkedList();

    public static void main(String[] args) {
        int[] drawnNumbers = {1, 15, 16, 25, 32, 36};
//        int[] drawnNumbers = {1, 15, 16, 25};
//        int[] drawnNumbers = {1, 15, 16};

        populateList(list, 51000000);

        List<Integer> directOrderPositions = findSequencePositions(drawnNumbers, true);
        int directOrderOccurrences = directOrderPositions.size();

        List<Integer> reverseOrderPositions = findSequencePositions(drawnNumbers, false);
        int reverseOrderOccurrences = reverseOrderPositions.size();

        System.out.println("Results for the sequence " + java.util.Arrays.toString(drawnNumbers) + ":\n");
        System.out.println("Direct Order:");
        System.out.println("Positions: " + directOrderPositions);
        System.out.println("Occurrences: " + directOrderOccurrences);

        System.out.println("\nReverse Order:");
        System.out.println("Positions: " + reverseOrderPositions);
        System.out.println("Occurrences: " + reverseOrderOccurrences);


    }

    private static void populateList(DoubleLinkedList list, int quantity) {
        for (int i = 0; i < quantity; i++) {
            int number = random.nextInt(60) + 1;
            list.addLast(number);
        }
    }

    private static List<Integer> findSequencePositions(int[] drawnNumbers, boolean isDirectOrder) {
        Cell current = isDirectOrder ? list.getFirst() : list.getLast();
        List<Integer> positions = new ArrayList<>();

        int index = isDirectOrder ? 0 : list.getSize() - 1;
        while (current != null) {

            if (current.getNumber() == drawnNumbers[0]) {
                Cell sequenceCurrent = current;
                boolean sequenceFound = true;

                for (int j = 1; j < drawnNumbers.length; j++) {
                    sequenceCurrent = isDirectOrder ? sequenceCurrent.getNext() : sequenceCurrent.getPrevious();

                    if (sequenceCurrent == null || sequenceCurrent.getNumber() != drawnNumbers[j]) {
                        sequenceFound = false;
                        break;
                    }
                }

                if (sequenceFound) {
                    positions.add(index);
                }
            }

            current = isDirectOrder ? current.getNext() : current.getPrevious();
            index = isDirectOrder ? index + 1 : index - 1;
        }

        return positions;
    }
}
