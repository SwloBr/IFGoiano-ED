package com.swlo.ex3;

import java.util.Scanner;

public class AirportControl {
    private AirplaneQueue airplaneQueue = new AirplaneQueue();

    public AirportControl() {
        airplaneQueue.enqueue(new Airplane("Airbus A320", 01));
        airplaneQueue.enqueue(new Airplane("Boeing 737", 01));
    }

    public void listAirplaneCount() {
        int count = airplaneQueue.getSize();
        System.out.println("Number of airplanes waiting for takeoff: " + count);
    }

    public void listAirplanes() {
        if (airplaneQueue.isEmpty()) {
            System.out.println("No airplanes waiting for takeoff.");
        } else {
            System.out.println("Airplanes waiting for takeoff:");
            for (Airplane airplane : airplaneQueue) {
                System.out.println(airplane.getName() + " (" + airplane.getNumber() + ")");
            }
        }
    }

    public void authorizeTakeoff() {
        if (airplaneQueue.isEmpty()) {
            System.out.println("No airplanes waiting for takeoff.");
        } else {
            Airplane airplane = airplaneQueue.dequeue();
            System.out.println("Takeoff authorized for airplane " + airplane.getName() + " (" + airplane.getNumber() + ").");
        }
    }

    public void listFirstAirplane() {
        if (airplaneQueue.isEmpty()) {
            System.out.println("No airplanes waiting for takeoff.");
        } else {
            Airplane airplane = airplaneQueue.peek();
            System.out.println("Next airplane in waiting queue: " + airplane.getName() + " (" + airplane.getNumber() + ")");
        }
    }

    public static void main(String[] args) {
        AirportControl airportControl = new AirportControl();
        int option = 0;

        while (option != 5) {
            System.out.println("\nEnter the number of the desired option:");
            System.out.println("1. List number of airplanes waiting for takeoff");
            System.out.println("2. List all airplanes in waiting queue");
            System.out.println("3. Authorize takeoff for first airplane in queue");
            System.out.println("4. List characteristics of first airplane in queue");
            System.out.println("5. Exit");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    airportControl.listAirplaneCount();
                    break;
                case 2:
                    airportControl.listAirplanes();
                    break;
                case 3:
                    airportControl.authorizeTakeoff();
                    break;
                case 4:
                    airportControl.listFirstAirplane();
                    break;
                default:
                    System.out.println("Option not available");
                    break;
            }
        }
    }
}
