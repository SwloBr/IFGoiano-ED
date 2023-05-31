package com.swlo;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int totalPatients = 100;
        int maxGroupSize = 10;

        Deque<Patient> queue = new Deque<>();
        Deque<Patient> notAttended = new Deque<>();

        generateRandomPatients(queue, totalPatients);

        int groupSize = 1;
        int patientsAttended = 0;

        while (!queue.isEmpty() && patientsAttended < totalPatients) {
            if (groupSize <= queue.size() && groupSize <= maxGroupSize) {
                attendPatients(queue, groupSize);
                patientsAttended += groupSize;
            } else {
                moveRemainingPatients(queue, notAttended);
                groupSize = 1;
            }

            groupSize++;
        }

        organizeRemainingPatients(queue, notAttended);

        organizeGroupByTier(notAttended);


            System.out.println("Remaining patients:");
            printNotAttendedPatients(notAttended);

    }

    private static void generateRandomPatients(Deque<Patient> queue, int totalPatients) {
        Random random = new Random();

        for (int i = 1; i <= totalPatients; i++) {
            String name = "Patient " + i;
            String gender = random.nextBoolean() ? "Male" : "Female";
            int age = random.nextInt(80) + 1;

            boolean pregnant;

            if (gender.equals("Female")) {
                pregnant = random.nextBoolean();
            } else {
                pregnant = false;
            }

            boolean lactating = random.nextBoolean();
            boolean disabled = random.nextBoolean();

            Patient patient;

            if (random.nextBoolean()) {
                patient = new Patient(i, name, gender, age, pregnant, lactating, disabled);
            } else {
                patient = new Patient(i, name, gender, age);
            }

            queue.addLast(patient);
        }
    }

    private static void attendPatients(Deque<Patient> queue, int groupSize) {
        System.out.println("Group size: " + groupSize);

        Deque<Patient> tempQueue = new Deque<>();

        for (int i = 0; i < groupSize; i++) {
            Patient patient = queue.removeFirst();
            tempQueue.addLast(patient);
        }

        organizeGroupByTier(tempQueue);
        while (!tempQueue.isEmpty()) {
            Patient patient = tempQueue.removeFirst();
            System.out.println("Patient ID: " + patient.getID() + " - Name: " + patient.getName() + " - Tier: " + patient.getTier());
        }

        while (!tempQueue.isEmpty()) {
            Patient patient = tempQueue.removeFirst();
            queue.addLast(patient);
        }
    }

    private static void organizeGroupByTier(Deque<Patient> queue) {
        Deque<Patient> zeroQueue = new Deque<>();
        Deque<Patient> oneQueue = new Deque<>();
        Deque<Patient> twoQueue = new Deque<>();
        Deque<Patient> threeQueue = new Deque<>();

        while (!queue.isEmpty()) {
            Patient patient = queue.removeFirst();

            if (patient.getTier() == 0) {
                zeroQueue.addLast(patient);
            } else if (patient.getTier() == 1){
                oneQueue.addLast(patient);
            } else if (patient.getTier() == 2){
                twoQueue.addLast(patient);
            } else if (patient.getTier() == 3){
                threeQueue.addLast(patient);
            }
        }

        while (!oneQueue.isEmpty()) {
            Patient patient = oneQueue.removeFirst();
            queue.addFirst(patient);
        }
        while (!twoQueue.isEmpty()) {
            Patient patient = twoQueue.removeFirst();
            queue.addFirst(patient);
        }
        while (!threeQueue.isEmpty()) {
            Patient patient = threeQueue.removeFirst();
            queue.addFirst(patient);
        }
        while (!zeroQueue.isEmpty()) {
            Patient patient = zeroQueue.removeFirst();
            queue.addLast(patient);
        }
    }

    private static void moveRemainingPatients(Deque<Patient> queue, Deque<Patient> notAttended) {
        while (!queue.isEmpty()) {
            Patient patient = queue.removeFirst();
            notAttended.addLast(patient);
        }
    }

    private static void organizeRemainingPatients(Deque<Patient> queue, Deque<Patient> notAttended) {
        while (!queue.isEmpty()) {
            Patient patient = queue.removeFirst();
            notAttended.addLast(patient);
        }
    }


    private static void printNotAttendedPatients(Deque<Patient> notAttended) {
        while (!notAttended.isEmpty()) {
            Patient patient = notAttended.removeFirst();
            System.out.println("Patient ID: " + patient.getID() + " - Name: " + patient.getName() + " - Tier: " + patient.getTier());
        }
    }
}
