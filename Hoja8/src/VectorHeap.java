import java.util.Vector;
/**
 * @author UVG
 * @version 2.0, 1 de octubre de 2016
 * @param <E> Para indicar el tipo de objeto que almacenara la cola.
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>
{
	/* Atributos*/
	protected Vector<E> data; // the data, kept in heap order

	
	/**
	 * Contructor para inicializar la cola prioritaria.
	 */
	public VectorHeap(){
		data = new Vector<E>();
	}
	
	/**
	 * @param v vector de tipo E 
	 *  Constrctor para construir una cola prioritaria, recibiendo la cola en desorden.
	 */
	public VectorHeap(Vector<E> v)
	{
		int i;
		data = new Vector<E>(v.size()); // Obtener tamano del vector
		for (i = 0; i < v.size(); i++){ 
			add(v.get(i)); //Agregar elementos al heap
		}
	}
	
	/**
	 * @param i posicion del nodo 
	 * @return el padre del nodo en la posicion i
	 */
	protected static int parent(int i){
		return (i-1)/2;
	}

	/**
	 * @param i posicion del nodo 
	 * @return posicion del hijo izquierdo del nodo en la posicion i
	 */
	protected static int left(int i){
		return 2*i+1;
	}
	/**
	 * @param i posicion del nodo 
	 * @return posicion del hijo derecho del nodo en la posicion i
	 */
	protected static int right(int i){
		return (2*i+1) + 1;
	}

	/**
	 * @param leaf posicion del valor que tal vez este fuera de lugar
	 * Este metodo empuja el valor ingresado hacia la raiz hasta que encuentre su posicion
	 * apropiada.
	 */
	protected void percolateUp(int leaf){
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 &&
				(value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}

	/* (non-Javadoc)
	 * @see PriorityQueue#add(java.lang.Comparable)
	 * Manda la posicion del valor agregado al metodo percolateUp
	 */
	public void add(E value){
		data.add(value);
		percolateUp(data.size()-1);
	}

	/**
	 * @param root la posicion de la raiz del arbol
	 * Mueve el nodo hacia la raiz para luego poner para luego
	 * vaya a su posicion correcta en el heap.
	 */
	protected void pushDownRoot(int root){
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
						((data.get(childpos+1)).compareTo
								(data.get(childpos)) < 0))
				{
					childpos++;
				}
				// Assert: childpos indexes smaller of two children
				if ((data.get(childpos)).compareTo
						(value) < 0)
				{
					data.set(root,data.get(childpos));
					root = childpos; // Sigue abajo
				} else { // Encuentra posicion a la derecha
					data.set(root,value);
					return;
				}
			} else { // at a leaf! insert and halt
				data.set(root,value);
				return;
			}
		}
	}

	/* (non-Javadoc)
	 * @see PriorityQueue#remove()
	 *  
	 */
	public E remove(){
		//Pre si la cola no esta vacia
		if (isEmpty()==false){
			E minVal = getFirst();
			data.set(0,data.get(data.size()-1));
			data.setSize(data.size()-1);
			if (data.size() > 1) pushDownRoot(0);
			return minVal;
		}
		else{
			return null;
		}
	
	}

	/* (non-Javadoc)
	 * @see PriorityQueue#getFirst()
	 */
	@Override
	public E getFirst() {
		return data.get(0);
	}

	/* (non-Javadoc)
	 * @see PriorityQueue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	/* (non-Javadoc)
	 * @see PriorityQueue#size()
	 */
	@Override
	public int size() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see PriorityQueue#clear()
	 */
	@Override
	public void clear() {
		int i=0;
		while(data.isEmpty()==false){
			data.remove(i);
			i++;
		}
	}
}