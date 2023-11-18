package Etapa4;

import exceptions.OverflowException;
import exceptions.UnderflowException;
import interfaces.IStack;

public class LinkedStack<T> implements IStack<T> {

    public static void main(String[] args) {

        LinkedStack<String> stringStack = new LinkedStack<String>(4);

        stringStack.push("Nome 1");
        stringStack.push("Nome 2");
        stringStack.push("Nome 3");
        stringStack.push("Nome 4");

        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());

    }

    public Node<T> head = null;
    public int numElements = 0;
    public int maxSize = 0;

    public LinkedStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public T pop() throws UnderflowException {
        if (this.numElements == 0)
            throw new UnderflowException("Underflow");
        T value = this.head.getElement();
        this.head = this.head.getNext();
        this.numElements--;
        return value;
    }

    public void push(T value) throws OverflowException {
        if (this.numElements >= this.maxSize)
            throw new OverflowException("Lista cheia.");

        Node<T> newNode = new Node<T>(value);
        if (this.numElements == 0) {
            this.head = newNode;
        } else {
            Node<T> temp = this.head;
            this.head = newNode;
            this.head.setNext(temp);
        }

        this.numElements++;
    }

    public boolean isEmpty() {
        return this.numElements == 0;
    }

    public boolean isFull() {
        return this.numElements == this.maxSize;
    }

    public T top() throws UnderflowException {
        if (this.numElements == 0)
            throw new UnderflowException("Underflow");
        T value = this.head.getElement();
        return value;
    }

    public int numElements() {
        return this.numElements;
    }

}
