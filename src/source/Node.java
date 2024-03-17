package source;

/**
 * Clase que representa un nodo en la lista encadenada de pares
 * clave-valor. Cada nodo contiene una clave, un valor y una 
 * referencia al siguiente nodo en la lista
 */
public class Node<K, V> {
    private final K key;
    private V value;
    protected Node<K, V> next;
    protected Node<K,V> previous;
    /**
     * Constructor de un objeto de la clase Node
     * @param key Clave
     * @param value Valor
     */
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    /**
     * Método que devuelve la clave de un nodo
     * @return Clave correspondiente al nodo
     */
    public K getKey() {
        return this.key;
    }

    /**
     * Método que devuelve el valor de un nodo
     * @return Valor asociado al nodo
     */
    public V getValue() {
        return this.value;
    }
    
    /**
     * Método que actualiza el valor de un nodo
     * @param value Nuevo valor a asociar con el nodo
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Método que se encarga de representar un nodo como una String
     * @return Representación como String del nodo
     */
    @Override
    public String toString() {
        return this.key + " : " + this.value;
    }
    
    /**
     * Método para comparar si dos nodos son iguales, es decir,
     * tienen la misma clave y el mismo valor asociado
     * @return Valor booleano resultante de la comparación
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) {
            return false;
        }
        Node<K, V> other = (Node<K, V>) obj;
        return (this.key.equals(other.key) 
                && this.value.equals(other.value));
    }
}