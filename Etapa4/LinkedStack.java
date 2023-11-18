package Etapa4;

import exceptions.UnderflowException;
import interfaces.IStack;

public class LinkedStack<T> implements IStack<T> {

    public static void main(String[] args) {
        LinkedStack<String> stringStack = new LinkedStack<String>("Teste", 10);
        stringStack.push("Nome 1");
        stringStack.push("Nome 2");
        stringStack.push("Nome 3");

    }

    public Node<T> head;
    public int last = 0;
    public int size = 0;

    public LinkedStack(T firstValue, int size) {
        Node<T> firstNode = new Node<T>(firstValue);
        this.head = firstNode;
        this.size = size == 0 ? 1 : size;
        this.last++;
    }

    public static String teste(int val) {
        return (Integer.toString(val));
    }

    public T pop() throws UnderflowException {
        if (this.last == 0)
            throw new UnderflowException("Underflow");
        T value = this.head.getElement();
        this.head = this.head.getNext();
        this.last--;
        return value;
    }

    public void push(T value) {
        Node<T> newNode = new Node<T>(value);
        Node<T> temp = this.head;
        this.head = newNode;
        this.head.next = temp;
        this.last++;
    }

    public boolean isEmpty() {
        return this.last == 0;
    }

    public boolean isFull() {
        return this.last == this.size;
    }

    public T top() throws UnderflowException {
        if (this.last == 0)
            throw new UnderflowException("Underflow");
        T value = this.head.getElement();
        return value;
    }

    public int numElements() {
        return this.last;
    }
}
