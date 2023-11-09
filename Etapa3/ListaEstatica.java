package Etapa3;

public class ListaEstatica<T> {

    protected T[] list;
    protected int size = 0;
    public int length = 0;

    @SuppressWarnings("unchecked")
    public ListaEstatica(int size) {

        this.list = (T[]) new Object[size];
    }

    public void add(T element) {
        if (this.isFull())
            throw new StackOverflowError();

        this.list[length] = element;
        this.length++;
    }

    public T get(int pos) {
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

    public int contaElementos(T el) throws Exception {
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
