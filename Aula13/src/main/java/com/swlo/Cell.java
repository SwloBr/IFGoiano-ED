package com.swlo;

public class Cell {
    private int number;
    private Cell previous;
    private Cell next;

    public Cell(int number) {
        this.number = number;
        this.previous = null;
        this.next = null;
    }

    public int getNumber() {
        return number;
    }

    public Cell getPrevious() {
        return previous;
    }

    public void setPrevious(Cell previous) {
        this.previous = previous;
    }

    public Cell getNext() {
        return next;
    }

    public void setNext(Cell next) {
        this.next = next;
    }

}