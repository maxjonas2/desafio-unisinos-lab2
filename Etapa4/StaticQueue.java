package Etapa4;

import exceptions.OverflowException;
import exceptions.UnderflowException;
import interfaces.IQueue;

public class StaticQueue<E> implements IQueue<E> {

    protected int first = -1;
    protected int last = -1;
    protected int size = 0;
    protected E[] queue;

    @SuppressWarnings("unchecked")
    public StaticQueue(int size) {
        if (size <= 0)
            throw new IllegalArgumentException();
        this.queue = (E[]) new Object[size];
    }

    public E back() throws UnderflowException {
        return null;
    }

    public E dequeue() throws UnderflowException {
        if (this.isEmpty())
            throw new UnderflowException("Lista vazia");

        E element = this.queue[first];
        this.queue[first] = null;

        this.first++;

        if (this.first == this.queue.length - 1)
            this.first = 0;

        return element;
    }

    public void enqueue(E element) throws OverflowException {
        if (this.isFull())
            throw new OverflowException("Fila cheia.");

        // Check if is end of array

        this.last++;
        this.queue[this.last] = element;

    }

    public E front() throws UnderflowException {
        // Handle circleback case
        return this.queue[this.first];
    }

    public boolean isEmpty() {
        return this.last == -1 && this.first == -1;
    }

    public boolean isFull() {
        return Math.abs(this.last) - Math.abs(this.first) == this.size - 1;
    }

    public int numElements() {
        return 0;
    }

}
