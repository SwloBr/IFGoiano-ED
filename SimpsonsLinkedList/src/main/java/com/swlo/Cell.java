package com.swlo;

public class Cell {
    Cell next;
    Cell previus;
    Object element;

    Cell(Cell next, Object element) {
        this.next = next;
        this.previus = null;
        this.element = element;
    }

    Cell(Object element) {
        this.next = null;
        this.previus = null;
        this.element = element;
    }

    void setNext(Cell next) {
        this.next = next;
    }

    void setPrevius(Cell previus) {
        this.previus = previus;
    }

    Cell getNext() {
        return this.next;
    }
    Cell getPrevius() {
        return this.previus;
    }
    Object getElement() {
        return this.element;
    }

}
