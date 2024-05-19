package juniverse.core.collections;

import java.util.Iterator;

/**
 *
 * @author tunm2
 */
class MyCollectionImpl implements Iterable<Integer> {

    public Integer[] elements;
    private int size;

    public MyCollectionImpl(Integer[] elements) {
        this.elements = elements;
    }
    
    public void add(int element) {
        elements[size++] = element;
        modCount++;
    }
    
    public void remove(int pos) {
        elements[pos] = null;
        size--;
        modCount++;
    }
    
    private transient int modCount;

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Integer> {

        private int cursor;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return this.cursor < elements.length;
        }

        @Override
        public Integer next() {
            return elements[++cursor];
        }

        @Override
        public void remove() {
            
        }
    }
}
