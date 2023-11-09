package Etapa4;

public class LinkedStack<T> implements Stack<T> {

    public static void main(String[] args) {
        LinkedStack<String> stringStack = new LinkedStack<String>("Teste");
        stringStack.push("Nome 1");
        stringStack.push("Nome 2");
        stringStack.push("Nome 3");

    }

    public Node<T> head;
    public int size = 0;

    public LinkedStack(T firstValue) {
        Node<T> firstNode = new Node<T>(firstValue);
        this.head = firstNode;
        this.size++;
    }

    public T pop() throws Exception {
        if (this.size == 0)
            throw new Exception("Underflow");
        T value = this.head.value;
        this.head = this.head.next;
        this.size--;
        return value;
    }

    public void push(T value) {
        Node<T> newNode = new Node<T>(value);
        Node<T> temp = this.head;
        this.head = newNode;
        this.head.next = temp;
        this.size++;
    }

    public T top() {
        // Check if empty
        return this.head.value;
    }
}

interface Stack<T> {
    public void push(T value);

    public T top();

    public T pop() throws Exception;
}
