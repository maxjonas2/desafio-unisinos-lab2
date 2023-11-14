package Etapa4;

import java.util.Queue;

import exceptions.OverflowException;
import exceptions.UnderflowException;

import java.lang.Object;

import interfaces.IQueue;

public class StaticQueue<E> implements IQueue<E> {

    protected int last = 0;
    protected int size = 0;
    protected E[] queue;

    @SuppressWarnings("unchecked")
    public StaticQueue(E firstElement, int size) {
        this.queue = (E[]) new Object[size];
    }

    public E back() throws UnderflowException {
        // TODO Auto-generated method stub
        return null;
    }

    public E dequeue() throws UnderflowException {
        // TODO Auto-generated method stub
        return null;
    }

    public void enqueue(E element) throws OverflowException {
        // TODO Auto-generated method stub

    }

    public E front() throws UnderflowException {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean isFull() {
        // TODO Auto-generated method stub
        return false;
    }

    public int numElements() {
        // TODO Auto-generated method stub
        return 0;
    }

}
