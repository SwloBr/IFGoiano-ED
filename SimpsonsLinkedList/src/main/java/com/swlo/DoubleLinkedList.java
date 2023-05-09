package com.swlo;

public class DoubleLinkedList {
    Cell first;
    Cell last;
    int elementsQuantity = 0;


    boolean occupedPosition(int pos) {
        return ((pos >= 0) && (pos < this.elementsQuantity));

    }

    Cell takeCell(int pos) {
        if (!this.occupedPosition(pos)) {
            throw new IllegalArgumentException("Posicao nao existe");
        } else {
            Cell atual = this.first;
            for (int i = 0; i < pos; i++) {
                atual = atual.getNext();
            }
            return (atual);
        }
    }

    Object take(int pos) {
        return (this.takeCell(pos).getElement());
    }

    void addFirst(Object elemento) {
        if (this.elementsQuantity == 0) {
            Cell nova = new Cell(elemento);
            this.first = nova;
            this.last = nova;
        } else {
            Cell nova = new Cell(this.first, elemento);
            this.first.setPrevius(nova);
            this.first = nova;
        }
        this.elementsQuantity++;
    }

    void addLast(Object elemento) {
        if (this.elementsQuantity == 0) {
            Cell nova = new Cell(elemento);
            this.first = nova;
            this.last = nova;
        } else {
            Cell nova = new Cell(elemento);
            this.last.setNext(nova);
            nova.setPrevius(last);
            this.last = nova;

        }
        this.elementsQuantity++;
    }

    void add(Object elemento) {
        if (this.elementsQuantity == 0) {
            this.addFirst(elemento);
        } else {
            Cell nova = new Cell(elemento);
            this.last.setNext(nova);
            nova.setPrevius(this.last);
            this.last = nova;
            this.elementsQuantity++;
        }
    }

    void add(int pos, Object elemento) {
        if (pos == 0) {
            this.addFirst(elemento);
        } else if (pos == this.elementsQuantity) {
            this.add(elemento);
        } else {
            Cell anterior = this.takeCell(pos - 1);
            Cell proxima = anterior.getNext();
            Cell nova = new Cell(anterior.getNext(), elemento);
            nova.setPrevius(anterior);
            anterior.setNext(nova);
            proxima.setPrevius(nova);
            this.elementsQuantity++;
        }
    }

    void removeFirst() {
        if (!this.occupedPosition(0)) {
            throw new IllegalArgumentException("Posicao não Existe");
        } else {
            this.first = this.first.getNext();
            this.elementsQuantity--;
        }
        if (this.elementsQuantity == 0) {
            this.last = null;
        }
    }


    void removeLast() {
        if (!this.occupedPosition(elementsQuantity - 1)) {
            throw new IllegalArgumentException("Posicao nao existe");
        } else {
            if (this.elementsQuantity == 1) {
                this.removeFirst();
            } else {
                Cell penultima = this.last.getPrevius();
                penultima.setNext(null);
                this.last = penultima;
                this.elementsQuantity--;
            }
        }
    }

    void remove(int pos) {
        if (!this.occupedPosition(pos)) {
            throw new IllegalArgumentException("Posicao nao Existe");
        } else {
            if (pos == 0) {
                this.removeFirst();
            } else if (pos == this.elementsQuantity - 1) {
                this.removeLast();
            } else {
                Cell anterior = this.takeCell(pos - 1);
                Cell atual = anterior.getNext();
                Cell proxima = atual.getNext();
                anterior.setNext(proxima);
                proxima.setPrevius(anterior);
                this.elementsQuantity--;
            }
        }
    }

    boolean contains(Object elemento) {
        Cell atual = this.first;
        while (atual != null) {
            if (atual.getElement().equals(elemento)) {
                return (true);
            }
            atual = atual.getNext();
        }
        return (false);
    }

    int size() {
        return (this.elementsQuantity);
    }

    void clearList() {
        this.first = null;
        this.last = null;
        this.elementsQuantity = 0;
    }

    @Override
    public String toString() {
        if (this.elementsQuantity == 0) {
            return ("[]");
        } else {
            StringBuilder builder = new StringBuilder("[");
            Cell atual = this.first;
            for (int i = 0; i < this.elementsQuantity - 1; i++) {
                builder.append(atual.getElement());
                builder.append(", ");
                atual = atual.getNext();
            }
            builder.append(atual.getElement());
            builder.append("]");
            return (builder.toString());
        }
    }

}








