package com.swlo;

public class DoubleLinkedList {
    private Cell first;
    private Cell last;
    private int size;

    public DoubleLinkedList() {
    }

    public void addFirst(int number) {
        Cell newCell = new Cell(number);

        if (first == null) {
            first = newCell;
            last = newCell;
        } else {
            newCell.setNext(first);
            first.setPrevious(newCell);
            first = newCell;
        }

        size++;
    }

    public void addLast(int number) {
        Cell newCell = new Cell(number);

        if (last == null) {
            first = newCell;
            last = newCell;
        } else {
            newCell.setPrevious(last);
            last.setNext(newCell);
            last = newCell;
        }

        size++;
    }

    public void removeFirst() {
        if (first == null) {
            return;
        }

        if (first == last) {
            first = null;
            last = null;
        } else {
            Cell next = first.getNext();
            next.setPrevious(null);
            first = next;
        }

        size--;
    }

    public void removeLast() {
        if (last == null) {
            return;
        }

        if (first == last) {
            first = null;
            last = null;
        } else {
            Cell previous = last.getPrevious();
            previous.setNext(null);
            last = previous;
        }

        size--;
    }


    public void insertSorted(int number) {
        Cell newCell = new Cell(number);

        if (first == null) {
            first = newCell;
            last = newCell;
        } else if (number <= first.getNumber()) {
            newCell.setNext(first);
            first.setPrevious(newCell);
            first = newCell;
        } else if (number >= last.getNumber()) {
            newCell.setPrevious(last);
            last.setNext(newCell);
            last = newCell;
        } else {
            Cell current = first;

            while (number > current.getNumber()) {
                current = current.getNext();
            }

            Cell previous = current.getPrevious();
            previous.setNext(newCell);
            newCell.setPrevious(previous);
            newCell.setNext(current);
            current.setPrevious(newCell);
        }
        size++;
    }

    public void removePrimes() {
        Cell current = first;
        while (current != null) {
            if (isPrime(current.getNumber())) {
                Cell next = current.getNext();
                Cell previous = current.getPrevious();
                if (previous != null) {
                    previous.setNext(next);
                } else {
                    first = next;
                }
                if (next != null) {
                    next.setPrevious(previous);
                } else {
                    last = previous;
                }
                current = next;
                size--;
            } else {
                current = current.getNext();
            }
        }
    }

    public void removeNonPrimes() {
        Cell current = first;
        while (current != null) {
            if (!isPrime(current.getNumber())) {
                Cell next = current.getNext();
                Cell previous = current.getPrevious();
                if (previous != null) {
                    previous.setNext(next);
                } else {
                    first = next;
                }
                if (next != null) {
                    next.setPrevious(previous);
                } else {
                    last = previous;
                }
                current = next;
                size--;
            } else {
                current = current.getNext();
            }
        }
    }

    public void printCrescent() {
        Cell current = first;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.getNumber() + " ");
            current = current.getNext();
        }
        System.out.print("]\n");
    }

    public void printDecrescent() {
        Cell current = last;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.getNumber() + " ");
            current = current.getPrevious();
        }
        System.out.print("]\n");
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    public DoubleLinkedList duplicateList() {
        DoubleLinkedList newList = new DoubleLinkedList();
        Cell current = first;

        while (current != null) {
            int number = current.getNumber();
            newList.insertSorted(number);

            Cell duplicatedNode = new Cell(number);
            Cell next = current.getNext();

            if (next != null) {
                current.setNext(duplicatedNode);
                duplicatedNode.setPrevious(current);
                duplicatedNode.setNext(next);
                next.setPrevious(duplicatedNode);
            } else {
                current.setNext(duplicatedNode);
                duplicatedNode.setPrevious(current);
                last = duplicatedNode;
            }

            current = next;
        }

        return newList;
    }

    public int getSize() {
        return size;
    }

    public Cell getFirst() {
        return first;
    }

    public Cell getLast() {
        return last;
    }
}