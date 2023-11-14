package interfaces;

import exceptions.OverflowException;
import exceptions.UnderflowException;

/**
 * Interface que define o comportamento de uma Pilha.
 */
public interface IStack<E> {
	/**
	 * Informa se a pilha esta vazia.
	 * 
	 * @return Verdadeiro se a pilha estiver vazia, falso caso contr�rio.
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
	 * Adiciona um novo elemento a pilha.
	 * 
	 * @param element O elemento a ser adicionado
	 */
	public void push(E element) throws OverflowException;

	/**
	 * Retira um elemento da pilha.
	 * 
	 * @return O elemento retirado
	 */
	public E pop() throws UnderflowException;

	/**
	 * Informa qual o elemento no topo da pilha.
	 * 
	 * @return O elemento atualmente no topo da pilha
	 */
	public E top() throws UnderflowException;
}
