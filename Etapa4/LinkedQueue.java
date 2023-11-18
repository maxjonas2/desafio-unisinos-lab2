package Etapa4;

import exceptions.OverflowException;
import exceptions.UnderflowException;
import interfaces.IQueue;

public class LinkedQueue<T> implements IQueue<T> {

    private Node<T> first = null;
    private Node<T> last;
    private int maxSize = 0;
    private int numElements = 0;

    public LinkedQueue(int maxSize) {
        this.maxSize = maxSize;

    }

    @Override
    public void enqueue(T element) throws OverflowException {
        if (numElements >= maxSize)
            throw new OverflowException("Pilha cheia.");

        Node<T> newNode = new Node<T>(element);

        if (numElements == 0) {
            this.first = newNode;
            this.last = newNode;

        } else {
            Node<T> temp = this.last;
            this.last = newNode;
            temp.setNext(this.last);
        }

        this.numElements++;
    }

    @Override
    public void printQueue() throws UnderflowException {
        Node<T> current = this.first;

        while (current != null) {
            print(current.getElement());
            current = current.getNext();
        }
    }

    private void print(Object o) {
        System.out.println(o);
    }

    @Override
    public boolean isEmpty() {
        return this.numElements == 0;
    }

    @Override
    public boolean isFull() {
        return this.numElements == this.maxSize;
    }

    @Override
    public int numElements() {
        return this.numElements;
    }

    @Override
    public T dequeue() throws UnderflowException {
        if (numElements == 0)
            throw new UnderflowException("Pilha vazia");

        Node<T> returnedNode;

        if (this.numElements == 1) {
            returnedNode = this.first;
            this.first = null;
            this.last = null;
        } else {
            returnedNode = this.first;
            this.first = this.first.getNext();
        }

        this.numElements--;
        return returnedNode.getElement();
    }

    @Override

    public T front() throws UnderflowException {
        if (numElements == 0)
            throw new UnderflowException("Pilha vazia");

        return this.first.getElement();
    }

    @Override
    public T back() throws UnderflowException {
        if (numElements == 0)
            throw new UnderflowException("Pilha vazia");

        return this.last.getElement();
    }

}
