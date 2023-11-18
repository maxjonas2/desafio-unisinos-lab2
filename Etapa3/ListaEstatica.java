package Etapa3;

import exceptions.OverflowException;
import exceptions.UnderflowException;

public class ListaEstatica<E> {

    protected E[] list;
    protected int size = 0;
    public int numElementos = 0;

    public static void main(String args[]) {
        ListaEstatica<String> lista = new ListaEstatica<>(10);

        try {
            lista.add("Jonas");
            lista.add("Max");
            lista.add("Paulo");
            lista.add("Paulo");
            lista.add("Outro");
            lista.add("Jonas");
            lista.add("Jonas");
            System.out.println(lista.contaElementos("Outro"));
        } catch (UnderflowException e) {
            printErrorMessage(e);
        } catch (OverflowException e) {
            printErrorMessage(e);
        } catch (Exception e) {
            printErrorMessage(e);
        }
    }

    @SuppressWarnings("unchecked")
    public ListaEstatica(int size) {
        this.size = size;
        this.list = (E[]) new Object[size];
    }

    public void add(E element) throws OverflowException {
        if (this.isFull()) {
            throw new OverflowException("Lista cheia.");
        }

        this.list[numElementos++] = element;
    }

    public E get(int pos) {
        if (this.isEmpty() || pos + 1 > this.numElementos)
            throw new IndexOutOfBoundsException();
        return this.list[pos];
    }

    public boolean isEmpty() {
        return this.numElementos == 0;
    }

    public boolean isFull() {
        return this.numElementos == this.size;
    }

    // conta elementos atraves de simples iteracao, verificacao de nulo e comparacao
    // via 'equals'
    public int contaElementos(E el) throws UnderflowException {
        if (this.isEmpty())
            throw new UnderflowException("Lista vazia");

        int count = 0;

        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i] != null && this.list[i].equals(el))
                count++;
        }

        return count;
    }

    private static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

}
