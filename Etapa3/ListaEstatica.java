package Etapa3;

import java.util.Stack;

public class ListaEstatica<E> {

    protected E[] list;
    protected int size = 0;
    public int length = 0;

    @SuppressWarnings("unchecked")
    public ListaEstatica(int size) {

        this.list = (E[]) new Object[size];
    }

    public void add(E element) {
        if (this.isFull())
            throw new StackOverflowError();

        this.list[length] = element;
        this.length++;
    }

    public E get(int pos) {
        if (this.isEmpty() || pos + 1 > this.length)
            throw new IndexOutOfBoundsException();
        return this.list[pos];
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public boolean isFull() {
        return this.length == this.size;
    }

    public int contaElementos(E el) throws Exception {
        if (this.isEmpty())
            throw new Exception("Lista vazia");

        int count = 0;

        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i].equals(el))
                count++;
        }

        return count;
    }

}
