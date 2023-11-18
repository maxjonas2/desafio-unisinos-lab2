package interfaces;

import exceptions.OverflowException;
import exceptions.UnderflowException;

/**
 * Interface que define o comportamento de uma pilha.
 */
public interface IQueue<E> {
	/**
	 * Informa se a pilha esta vazia.
	 * 
	 * @return Verdadeiro se a pilha estiver vazia, falso caso contrario.
	 */
	public boolean isEmpty();

	/**
	 * Informa se a pilha esta cheia.
	 * 
	 * @return Verdadeiro se a pilha estiver cheia, falso caso contrario.
	 */
	public boolean isFull();

	/**
	 * Informa a quantidade de elementos armazenados na pilha.
	 * 
	 * @return A quantidade de elementos armazenados na pilha.
	 */
	public int numElements();

	/**
	 * Insere um novo elemento na pilha.
	 * 
	 * @param element O elemento a ser inserido
	 */
	public void enqueue(E element) throws OverflowException;

	/**
	 * Retira um elemento da pilha.
	 * 
	 * @return O elemento retirado
	 */
	public E dequeue() throws UnderflowException;

	/**
	 * Informa qual o primeiro elemento da pilha.
	 * 
	 * @return O primeiro elemento da pilha
	 */
	public E front() throws UnderflowException;

	/**
	 * Informa qual o ultimo elemento da pilha.
	 * 
	 * @return O ultimo elemento da pilha
	 */
	public E back() throws UnderflowException;

	public void printQueue() throws UnderflowException;
}
