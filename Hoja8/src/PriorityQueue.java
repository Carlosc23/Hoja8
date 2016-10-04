/**
 * @author UVG
 * @version 3.0 , 3 de octubre de 2016
 * @param <E> Para indicar de que tipo sera la cola de prioridad.
 */
public interface PriorityQueue<E extends Comparable<E>>
{
	/**
	 * @return el valor minimo en la cola de prioriddad
	 */
	public E getFirst();
	// pre: !isEmpty()
	// post: returns the minimum value in priority queue
	
	/**
	 * @return el valor removido de la cola de prioridad
	 */
	public E remove();
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	
	/**
	 * @param value agregado a la cola de prioridad
	 */
	public void add(E value);
	// pre: value is non-null comparable
	// post: value is added to priority queue
	
	/**
	 * @return true si la cola esta vacia, en caso contrario devuelve false.
	 */
	public boolean isEmpty();
	// post: returns true iff no elements are in queue
	
	/**
	 * @return el numero de elementos en la cola.
	 */
	public int size();
	// post: returns number of elements within queue
	
	/**
	 * Remueve todos los elementos de la cola.
	 */
	public void clear();
	// post: removes all elements from queue
}