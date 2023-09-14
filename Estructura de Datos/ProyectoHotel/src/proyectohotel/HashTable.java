package proyectohotel;

/*
* victorpointud
*/

/*
* Esta clase implementa un árbol binario de búsqueda genérico que soporta 
* las operaciones de agregar y buscar un nodo. Tiene una capacidad máxima y esta implementada como
* una lista "bucket" de listas de HashNodes, de esta manera si dos llaves tienen el mismo valor de hash
* lo que se hace es insertarse en una misma lista.
*/

public class HashTable<K, V> {
    private LinkedList<HashNode<K, V>>[] bucket;
    private int capacity;
    private int size;

    public class HashNode<K, V> {
        K key;
        V value;
        
        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable(int capacity) {
        this.bucket = new LinkedList[capacity];
        this.capacity = capacity;
        size = 0;
    }
    
    /*
     * Obtiene el índice perteneciente a la key, mediante su hash. 
     */
    
    public int getIndex(K key) {
       return Math.abs(key.hashCode()) % capacity;
    }
    
    /*
     * Inserta el nodo en la lista apropiada según su valor de hash. Si se intenta insertar
     * un nodo con una llave que que ya se encunetra insertada, se actualiza el valor del nodo.
     */
     
    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<HashNode<K, V>> list = bucket[index];
        if (list == null) {
            list = new LinkedList<>();
            bucket[index] = list;
        }
        int n = list.size;
        for (int i=0; i < n; i++) {
            HashNode<K, V> entry = list.get(i);
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        list.append(new HashNode<>(key, value));
        size++;
    }
    
    /*
     * Mediante el valor de hash de la llave accedemos a la posición de la lista deseada y 
     * en ella buscamos el nodo con el valor de la llave deseada. El orden de esta operación
     * en el mejor de los casos es O(1) y en el peor O(n).
     */
    
    public V get(K key) {
        int index = getIndex(key);
        LinkedList<HashNode<K, V>> list = bucket[index];
        if (list != null) {
            int n = list.size;
            for (int i=0; i < n; i++) {
                HashNode<K, V> entry = list.get(i);
                if (entry.key.equals(key))
                    return entry.value;
            }  
        }
        return null;
    }
    
    /*
     * Mediante el valor de hash de la llave accedemos a la posición de la lista deseada y 
     * la recorremos para eliminar el nodo deseado de esta lista.
     */
    
    public void delete(K key) {
        int index = getIndex(key);
        LinkedList<HashNode<K, V>> list = bucket[index];
        if (list != null) {
            int n = list.size;
            for (int i=0; i < n; i++) {
                HashNode<K, V> entry = list.get(i);
                if (entry.key.equals(key)){
                    list.delete(entry);
                    size--;
                    return;
                }
            }  
        }
    }
}
