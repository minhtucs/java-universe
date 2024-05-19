package juniverse.core.collections.map;

public class HashMaps<K, V> {
	
	/** An array of LinkedLists */
	Entry<K, V>[] table;
	/** Size of table */
	int size;
	int threshold;
	
	static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
	
	public V put(K key, V value) {
		// ----------------------------------
        int hash = hash(key.hashCode());
        // ----------------------------------
        for (Entry<K,V> e = table[hash]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }

        addEntry(hash, key, value, hash);
        return null;
    }
	
	public V get(Object key) {
        int hash = hash(key.hashCode());
        for (Entry<K,V> e = table[hash]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
                return e.value;
        }
        return null;
    }
	
	private void addEntry(int hash, K key, V value, int bucketIndex) {
		// Get the first element of linked list at hash position of array
		Entry<K, V> e = table[bucketIndex];
		// Insert new entry to the first of linked list
		table[bucketIndex] = new Entry<>(hash, key, value, e);
		// If the size is exceed the maximum then double it
		if (size++ >= threshold)
			resize(2 * table.length);
	}
	
	private void resize(int newSize) {
		
	}
	
	static class Entry<K, V> {
		final K key;
		V value;
		Entry<K, V> next;
		final int hash;
		
		Entry(int hash, K key, V value, Entry<K,V> next) {
	        this.value = value;
	        this.next = next;
	        this.key = key;
	        this.hash = hash;
	    }
	}
}
