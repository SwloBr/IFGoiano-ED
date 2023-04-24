package com.swlo;

public class Stack<T> {

    private int bucket;
    private int length = 0;
    private int capacity = 0;
    private T[] data;
    private boolean dynamic = false;
    private final int DEFAULT_CAPACITY = 10;

    /**
     * By default, the stack is dynamically allocated
     */
    public Stack() {
        this.data = (T[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.bucket = 10;
        this.length = 0;
        this.dynamic = true;
    }

    public Stack(int bucket) {
        this.bucket = bucket;
        this.data = (T[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public Stack(int capacity, int bucket) {
        this.capacity = capacity;
        this.bucket = bucket;
        this.data = (T[]) new Object[capacity];
    }

    public Stack(boolean dynamic) {
        this.dynamic = dynamic;
        this.data = (T[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        if (dynamic)
            this.bucket = 10;

        else
            this.bucket = 0;
    }

    public Stack(int capacity, boolean dynamic) {
        this.capacity = capacity;
        this.dynamic = dynamic;
        this.data = (T[]) new Object[capacity];
    }

    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < this.length; i++) {
            newData[i] = this.data[i];
            this.data[i] = null;
        }
        this.data = newData;
        this.capacity = newCapacity;
    }

    public void push(T element) {

        if (this.dynamic) {

            if (this.length == this.capacity) {
                this.resize(this.capacity + this.bucket);
            }
            this.data[this.length] = element;
            this.length++;
        }

        else {
            if (this.length < this.capacity) {
                this.data[this.length] = element;
                this.length++;
            }

            else
                throw new IllegalStateException("[Stack Error]: Stack is already full");
        }

        if (!this.dynamic && this.length == this.capacity) {

            throw new IllegalStateException("[Stack Error]: Stack is already full");
        }
    }

    public T pop() {
        if (this.length <= 0) {
            throw new IllegalStateException("[Stack Error]: Stack is empty");
        }
        T element = this.data[this.length - 1];
        this.data[this.length - 1] = null;
        this.length--;

        if (this.length < this.capacity - this.bucket) {
            resize(this.capacity - this.bucket);
        }
        return element;
    }

    public T peek() {
        if (this.length <= 0) {
            throw new IllegalStateException("[Stack Error]: Stack is empty");
        }
        return this.data[this.length - 1];
    }

    public boolean isEmpty() {
        return this.length <= 0;
    }

    public boolean isFull() {
        return this.length == this.capacity;
    }

    public int getLength() {
        return this.length;
    }
}