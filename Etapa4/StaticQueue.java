package Etapa4;

import java.util.Random;

import exceptions.OverflowException;
import exceptions.UnderflowException;
import interfaces.IQueue;

public class StaticQueue<E> implements IQueue<E> {

    private int first = -1;
    private int last = -1;
    private int maxSize = 0;
    private E[] queue;
    private int numElements = 0;

    public static void main(String[] args) throws OverflowException, UnderflowException {
        Random randGen = new Random();

        StaticQueue<Integer> q = new StaticQueue<Integer>(10);

        for (int i = 0; i < q.maxSize; i++) {
            q.enqueue(randGen.nextInt(20));
        }

        q.printQueue();

    }

    @SuppressWarnings("unchecked")
    public StaticQueue(int maxSize) {
        if (maxSize <= 1)
            throw new IllegalArgumentException();
        this.maxSize = maxSize;
        this.queue = (E[]) new Object[maxSize];
    }

    public E back() throws UnderflowException {
        if (this.isEmpty())
            throw new UnderflowException("Lista está vazia.");
        return this.queue[last];
    }

    public E dequeue() throws UnderflowException {
        if (this.isEmpty())
            throw new UnderflowException("Queue is empty");

        E element = this.queue[this.first];
        this.queue[this.first] = null;

        this.numElements--;

        if (this.numElements == 0) {
            this.resetIndices();
        } else if (this.first == this.maxSize - 1) {
            this.first = 0;
        } else {
            this.first++;
        }

        return element;
    }

    public void enqueue(E element) throws OverflowException {
        if (this.isFull()) {
            throw new OverflowException("Queue is full");
        } else if (this.isEmpty()) {
            this.first = 0;
            this.last = 0;
            System.out.println("Empty queue. Reset both indices to zero.");
        } else {
            if (this.last == this.maxSize - 1) {
                this.last = 0;
                System.out.println("Last index at final pos. Reset last index to zero.");
            } else {
                System.out.println("Incremented last index");
                this.last++;
            }
        }

        this.queue[this.last] = element;
        this.numElements++;
        System.out.println("Enqueued new element at position " + this.last);

    }

    public E front() throws UnderflowException {
        if (this.isEmpty())
            throw new UnderflowException("Pilha esta vazia.");
        return this.queue[first];
    }

    public boolean isEmpty() {
        return this.numElements == 0;
    }

    public boolean isFull() {
        return this.numElements == this.maxSize;
    }

    public int numElements() {
        return this.numElements;
    }

    public void printQueue() {
        String str = "[";
        for (E element : this.queue) {
            str += (element != null ? element.toString() : "null") + ", ";
        }
        str = str.substring(0, str.length() - 1);
        str += "]";
        System.out.println(str);
    }

    private void resetIndices() {
        this.first = -1;
        this.last = -1;
    }

}
