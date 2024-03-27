package structs;

public class HashMap<K, V> {

    private Node<K,V>[] bucket;
    private int size;
    private static final int MAX_HASHMAP_CAPACITY = 10;


    public HashMap() {
        this.bucket = new Node[MAX_HASHMAP_CAPACITY];
        this.size = 0;
    }

    public void put(K key, V value) {
        if (size == MAX_HASHMAP_CAPACITY) throw new ArrayIndexOutOfBoundsException("Max capacity reached.");
        int index = hash(key);
        Node<K,V> newNode = new Node<>(key, value);
        bucket[index] = newNode;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (bucket[index] == null) return null;
        return bucket[index].value;
    }

    public void clear() {
        this.bucket = new Node[10];
        this.size = 0;
    }

    public void delete(K key) {
        if (isEmpty()) throw new RuntimeException("Your HashMap is already empty.");
        bucket[hash(key)] = null;
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        if (key == null)  throw new IllegalArgumentException("Sua chave tem o valor nulo.");
        int hash = key.hashCode();
        return (hash ^ hash >>> 19) % bucket.length;
    }

    @Override
    public String toString() {
        String map = null;
        if (isEmpty()) map = "{}";

        var sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i < size; i++) {
            if (bucket[i] == null) continue;
            sb.append(bucket[i].value);
            if (i == size -1) map = sb.append('}').toString();
            sb.append(',').append(' ');
        }
        return map;
    }

    private static class Node<K,V> {
        final K key;
        final V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}
