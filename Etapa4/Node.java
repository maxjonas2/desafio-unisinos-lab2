package Etapa4;

public class Node<E> {

    private E element;
    private Node<E> next;

    public Node(E e) {
        element = e;
        next = null;
    }

    public E getElement() {
        return element;

    }

    public Node<E> getNext() {
        return next;
    }

    public void setElement(E e) {
        element = e;
    }

    public void setNext(Node<E> n) {
        next = n;
    }

}
