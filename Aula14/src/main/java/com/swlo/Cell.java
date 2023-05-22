package com.swlo;

public class Cell {
    Cell next;
    Cell previus;
    Object element;
    Cell headFirst;
    Cell headLast;

    public Cell getHeadFirst() {
        return headFirst;
    }

    public void setHeadFirst(Cell headFirst) {
        this.headFirst = headFirst;
    }

    public Cell getHeadLast() {
        return headLast;
    }

    public void setHeadLast(Cell headLast) {
        this.headLast = headLast;
    }

    Cell(Cell next, Object element) {
        this.next = next;
        this.previus = null;
        this.element = element;
        this.headFirst = null;
        this.headLast = null;
    }

    Cell(Object element) {
        this.next = null;
        this.previus = null;
        this.element = element;
        this.headFirst = null;
        this.headLast = null;
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
