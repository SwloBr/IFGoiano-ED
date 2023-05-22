package com.swlo;

public class DoubleLinkedList {
    private Cell first;
    private Cell last;
    private int elementsQuantity = 0;


    public DoubleLinkedList() {
    }

    public void remapHead(DoubleLinkedList list) {
        Cell element = null;
        for (int i = 0; i < list.elementsQuantity - 1; i++) {
            if (i == 0) {
                element = list.first;
            }
            element.setHeadFirst(list.first);
            element.setHeadLast(list.last);
            element = element.getNext();
        }
    }

    public DoubleLinkedList duplicate() {
        return this;
    }


    public void unify(DoubleLinkedList list1, DoubleLinkedList list2) {
        if (list1.isEmpty()) {
            this.first = list2.first;
            this.last = list2.last;
        } else if (list2.isEmpty()) {
            this.first = list1.first;
            this.last = list1.last;
        } else {
            this.first = list1.first;
            list1.last.setNext(list2.first);
            list2.first.setPrevius(list1.last);
            this.last = list2.last;
        }

        this.elementsQuantity = list1.elementsQuantity + list2.elementsQuantity;
        remapHead(list1);
    }

    private boolean isEmpty() {
        return first == null && last == null;
    }


    public boolean occupedPosition(int pos) {
        return ((pos >= 0) && (pos < this.elementsQuantity));

    }

    public void split(int pos, DoubleLinkedList list1, DoubleLinkedList list2) {
        if (!this.occupedPosition(pos)) {
            throw new IllegalArgumentException("Posicao nao existe");
        }

        if (pos == 0) {
            list1.first = this.first;
            list1.last = this.last;
            list1.elementsQuantity = this.elementsQuantity;
            list2.first = null;
            list2.last = null;
            list2.elementsQuantity = 0;
        } else if (pos == this.elementsQuantity - 1) {
            list1.first = null;
            list1.last = null;
            list1.elementsQuantity = 0;
            list2.first = this.first;
            list2.last = this.last;
            list2.elementsQuantity = this.elementsQuantity;
        } else {
            Cell splitCell = this.takeCell(pos);
            list1.first = this.first;
            list1.last = splitCell.getPrevius();
            list1.elementsQuantity = pos;
            list2.first = splitCell;
            list2.last = this.last;
            list2.elementsQuantity = this.elementsQuantity - pos;
            splitCell.getPrevius().setNext(null);
            splitCell.setPrevius(null);

            remapHead(list1);
            remapHead(list2);
        }
    }

    public DoubleLinkedList merge(DoubleLinkedList list1, DoubleLinkedList list2) {
        DoubleLinkedList mergedList = new DoubleLinkedList();

        Cell current1 = list1.first;
        Cell current2 = list2.first;

        while (current1 != null && current2 != null) {
            Comparable<Object> element1 = (Comparable<Object>) current1.getElement();
            Comparable<Object> element2 = (Comparable<Object>) current2.getElement();

            if (element1.compareTo(element2) <= 0) {
                mergedList.addLast(element1);
                current1 = current1.getNext();
            } else {
                mergedList.addLast(element2);
                current2 = current2.getNext();
            }
        }

        while (current1 != null) {
            mergedList.addLast(current1.getElement());
            current1 = current1.getNext();
        }

        while (current2 != null) {
            mergedList.addLast(current2.getElement());
            current2 = current2.getNext();
        }

        remapHead(mergedList);
        return mergedList;
    }

    public Cell getFirst() {
        return first;
    }

    public Cell getLast() {
        return last;
    }

    public int getElementsQuantity() {
        return elementsQuantity;
    }

    public Cell takeCell(int pos) {
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

    public Object take(int pos) {
        return (this.takeCell(pos).getElement());
    }

    public void addFirst(Object elemento) {
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
        remapHead(this);
    }

    public void addLast(Object elemento) {
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
        remapHead(this);
    }

    public void add(Object elemento) {
        if (this.elementsQuantity == 0) {
            this.addFirst(elemento);
        } else {
            Cell nova = new Cell(elemento);
            this.last.setNext(nova);
            nova.setPrevius(this.last);
            this.last = nova;
            this.elementsQuantity++;
            remapHead(this);
        }
    }

    public void add(int pos, Object elemento) {
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
            remapHead(this);
        }
    }

    public void removeFirst() {
        if (!this.occupedPosition(0)) {
            throw new IllegalArgumentException("Posicao não Existe");
        } else {
            this.first = this.first.getNext();
            this.elementsQuantity--;
        }
        if (this.elementsQuantity == 0) {
            this.last = null;
        }
        remapHead(this);
    }


    public void removeLast() {
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
        remapHead(this);
    }

    public void remove(int pos) {
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
        remapHead(this);
    }

    public boolean contains(Object elemento) {
        Cell atual = this.first;
        while (atual != null) {
            if (atual.getElement().equals(elemento)) {
                return (true);
            }
            atual = atual.getNext();
        }
        return (false);
    }

    public int size() {
        return (this.elementsQuantity);
    }

    public void clearList() {
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

    public int countElementsQuantity() {

        if (isEmpty()) {
            return 0;
        }
        if (last == first) {
            return 1;
        }
        int i = 1;
        Cell element = first;
        while (true) {
            i++;
            if (element.getNext() == null) {
                return i;
            }
            element = element.getNext();

        }

    }

}








