package source;

public class Diccionario {

    private static final int default_capacity = 16;
    private Node<Object, Object>[] buckets;
    private int size;
    private int capacity;
    private Node<Object, Object> first_node;
    private Node<Object, Object> last_node;

    /**
     * Constructor por omisión de un objeto de la clase Diccionario
     */
    public Diccionario() {
        this(default_capacity);
        this.capacity = default_capacity;
    }

    /**
     * Constructor de un objeto de la clase Diccionario
     * @param capacity Capacidad inicial del diccionario
     */
    public Diccionario(int capacity) {
        this.buckets = new Node[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     * Método para agregar un nuevo par clave-valor al diccionario
     * @param key Clave
     * @param value Valor 
     */
    public void add(Object key, Object value) {
        if (this.size >= this.capacity*0.8) {
            more_space();
        }
        int bucketIndex = (key.hashCode() & 0xfffffff) % buckets.length;
        Node<Object, Object> head = buckets[bucketIndex];
        while (head != null) {
            if (head.getKey().equals(key)) {
                head.setValue(value);
                return;
            }
            head = head.next;
            bucketIndex += 1;
            if (bucketIndex == buckets.length) {
                bucketIndex = 0;
            }
        }
        Node<Object, Object> newNode = new Node<>(key, value);
        newNode.next = buckets[bucketIndex];
        buckets[bucketIndex] = newNode;
        System.out.println(bucketIndex);
        this.size++;
        if (this.size == 1) {
            this.first_node = newNode;
        } else {
            newNode.previous = last_node;
            this.last_node.next = newNode;
        }
        this.last_node = newNode;
    }

    /**
     * Método que amplía la capacidad del diccionario cuando se encuentra lleno al 80%
     */
    public void more_space() {
        Diccionario nd = new Diccionario(this.capacity*2);
        Node<Object, Object> actual = this.first_node;
        while (actual != null) {
            nd.add(actual.getKey(), actual.getValue());
            actual = actual.next;
        }
        this.buckets = nd.buckets;
        this.capacity = nd.capacity;
        this.first_node = nd.first_node;
        this.last_node = nd.last_node;
    }

    /**
     * Método que devuelve el valor asociado a una clave
     * @param key Clave de la que se desea obtener el valor asociado
     * @return Valor asociado a la clave recibida
     */
    public Object get(Object key) {
        int bucketIndex = (key.hashCode() & 0xfffffff) % this.buckets.length;
        Node<Object, Object> head = this.buckets[bucketIndex];
        while (head != null) {
            if (head.getKey().equals(key)) {
                return head.getValue();
            }
            head = head.next;
        }
        return null;
    }

    /**
     * Método que devuelve el valor asociado a una clave
     * @param key Clave de la que se desea obtener el valor asociado
     * @param no_encontrado Valor devuelto si no se encuentra la clave 
     * @return Valor asociado a la clave recibida
     */
    public Object get(Object key, Object no_encontrado) {
        int bucketIndex = (key.hashCode() & 0xfffffff) % this.buckets.length;
        Node<Object, Object> head = this.buckets[bucketIndex];
        while (head != null) {
            if (head.getKey().equals(key)) {
                return head.getValue();
            }
            head = head.next;
        }
        return no_encontrado;
    }

    /**
     * Método que elimina un par clave-valor
     * @param key Clave del par clave-valor a eliminar
     * @return Valor de la clave pasada como parámetro si se encuentra
     * @return null en caso de no encontrarla acompañado de un mensaje de error
     */
    public Object pop(Object key)  {
        int bucketIndex = (key.hashCode() & 0xfffffff) % this.buckets.length;
        Node<Object, Object> head = this.buckets[bucketIndex];
        while (head != null) {
            if (head.getKey().equals(key)) {
                if (this.size == 1) {
                    this.first_node = null;
                    this.last_node = null;
                }
                else if (head.getKey().equals(this.first_node.getKey())) {
                    this.first_node = head.next;
                    this.first_node.previous = null;
                } else if (head.getKey().equals(this.last_node.getKey())) {
                    this.last_node = head.previous;
                    this.last_node.next = null;
                } else {
                    head.previous.next = head.next;
                    head.next.previous = head.previous;
                }
                this.buckets[bucketIndex] = null;
                this.size--;
                return head.getValue();
            }
            head = head.next;
        }
        System.out.println("KeyError: Clave no encontrada");
        return null;
    }

    /**
     * Método que elimina un par clave-valor
     * @param key Clave del par clave-valor a eliminar
     * @param no_encontrado Objeto que será devuelto en caso de no encontrar la clave
     * @return Valor de la clave pasada como parámetro si se encuentra
     * @return Objeto no_encontrado en caso de no encontrarla
     */
    public Object pop(Object key, Object no_encontrado)  {
        int bucketIndex = (key.hashCode() & 0xfffffff) % this.buckets.length;
        Node<Object, Object> head = this.buckets[bucketIndex];
        while (head != null) {
            if (head.getKey().equals(key)) {
                if (this.size == 1) {
                    this.first_node = null;
                    this.last_node = null;
                }
                else if (head.getKey().equals(this.first_node.getKey())) {
                    this.first_node = head.next;
                    this.first_node.previous = null;
                } else if (head.getKey().equals(this.last_node.getKey())) {
                    this.last_node = head.previous;
                    this.last_node.next = null;
                } else {
                    head.previous.next = head.next;
                    head.next.previous = head.previous;
                }
                this.buckets[bucketIndex] = null;
                this.size--;
                return head.getValue();
            }
            head = head.next;
        }
        return no_encontrado;
        }
        
    /**
    * Método que elimina el último par clave-valor añadido
    * @return Par clave-valor eliminado
    */
    public Node<Object, Object> popitem() {
        if (this.size == 0) {
            return null;
        } else {
            Node<Object, Object> temp = this.last_node;
            pop(this.last_node.getKey());
            return temp; 
        }
    }
    
    /**
     * Método que elimina un par clave-valor
     * @param key Clave del par clave-valor a eliminar
     * @return true si se encuentra la clave, false en caso contrario
     */
    public boolean remove(Object key) {
        int bucketIndex = (key.hashCode() & 0xfffffff) % this.buckets.length;
        Node<Object, Object> head = this.buckets[bucketIndex];
        while (head != null) {
            if (head.getKey().equals(key)) {
                if (this.size == 1) {
                    this.first_node = null;
                    this.last_node = null;
                }
                else if (head.getKey().equals(this.first_node.getKey())) {
                    this.first_node = head.next;
                    this.first_node.previous = null;
                } else if (head.getKey().equals(this.last_node.getKey())) {
                    this.last_node = head.previous;
                    this.last_node.next = null;
                } else {
                    head.previous.next = head.next;
                    head.next.previous = head.previous;
                }
                this.buckets[bucketIndex] = null;
                this.size--;
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * Método para añadir un par clave-valor si no está en el diccionario, si está se devuelve su valor
     * @param key Clave
     * @param value Valor
     * @return Valor si se encuentra la clave
     * @return null en caso contrario
     */
    public Object setdefault(Object key, Object value) {
        if (get(key) == null) {
            add(key, value);
            return null;
        } else {
            return get(key);
        }
    }

    /**
     * Método que devuelve el número actual de pares clave-valor en el diccionario
     * @return Número de pares clave-valor
     */
    public int size() {
        return size;
    }

    /**
     * Método que elimina todos los pares clave-valor del diccionario
     */
    public void clear() {
        Diccionario newDict = new Diccionario(this.capacity);
        this.buckets = newDict.buckets;
        this.size = 0;
    }
    /**
     * Método que realiza una copia de un diccionario
     * @return Una copia del diccionario
     */
    public Diccionario copy() {
        Diccionario nd = new Diccionario(this.capacity);
        nd.buckets = this.buckets;
        nd.first_node = this.first_node;
        nd.last_node = this.last_node;
        nd.size = this.size;
        return nd;
    }
    
    /**
     * Método que actualiza un diccionario con los elementos de otro diccionario
     * @param otro Diccionario con los valores para actualizar
     */
    public void update(Diccionario otro) {
        Node<Object, Object> actual = otro.first_node;
        while (actual != null) {
            this.add(actual.getKey(), actual.getValue());
            actual = actual.next;
        }
    }

    /**
     * Método que devuelve un array con todos los pares clave-valor
     * @return Un array con los pares clave-valor del diccionario
     */
    public Object[][] items() {
        if (this.size() != 0) {
            Object[][] items = new Object[this.size][2];
            Node<Object, Object> actual = this.first_node;
            int i = 0;
            while (actual != null) {
                items[i][0] = actual.getKey();
                items[i][1] = actual.getValue();
                actual = actual.next;
                i++;
            }
            return items;
        } else {
            return new Object[0][0];
        }
    }

    /**
     * Método que devuelve un array con todas las claves
     * @return Un array con las claves del diccionario
     */
    public Object[] keys() {
        Object[] keys = new Object[this.size];
        Node<Object, Object> actual = this.first_node;
        int i = 0;
        while (actual != null) {
            keys[i] = actual.getKey();
            actual = actual.next;
            i++;
        }
        return keys;
    }

    /**
     * Método que devuelve una array con todos los valores
     * @return Array con los valores del diccionario
     */
    public Object[] values() {
        Object[] values = new Object[this.size];
        Node<Object, Object> actual = this.first_node;
        int i = 0;
        while (actual != null) {
            values[i] = actual.getValue();
            actual = actual.next;
            i++;
        }
        return values;
    }

    /**
     * Método que devuelve una representación en cadena del diccionario
     * @return Representación en formato String del diccionario
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{");
        if (this.size == 0) {
            return "{}";
        }
        Node<Object, Object> actual = first_node;
        while (actual.next != null) {
            s.append(actual).append(", ");
            actual = actual.next;
        }
        s.append(actual);
        return s + "}";
    }

    /**
     * Método para comparar si dos diccionarios son iguales, es decir,
     * si tienen los mismos elementos en el mismo orden
     * @return Valor booleano resultante de la comparación
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Diccionario other)) {
            return false;
        }
        Node<Object, Object> actual_this = this.first_node;
        Node<Object, Object> actual_other = other.first_node;
        while (actual_this != null || actual_other != null) {
            assert actual_this != null;
            if (!actual_this.equals(actual_other)) {
                return false;
            }
            actual_this = actual_this.next;
            actual_other = actual_other.next;
        }
        return true;
    }
}