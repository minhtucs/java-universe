package juniverse.core.collections.map;

/**
 *
 * @author tunm2
 */
public class ZLruMap<K, V> {
    
    private Entry[] entries;
    
    public ZLruMap(int size) {
        this.entries = new Entry[size];
    }
    
    public boolean put(K key, V value) {
        Entry<K,V> entry = new Entry(key, value);
        int index = hash(key);
        entries[index] = entry;
        return true;
    }
    
    private int hash(K key) {
        return key.hashCode();
    }
    
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = entries[index];
        if (entry == null)
            return null;
        return entry.value;
    }
    
    static class Entry<K, V> {
        K key;
        V value;
        Entry prev;
        Entry next;
        
        Entry(K key, V value) {
            this(key, value, null, null);
        }
        
        Entry(K key, V value, Entry prev, Entry next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
