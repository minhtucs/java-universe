package juniverse.jdk.patterns;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author tunm2
 */
public class ComparatorInspector {

    public static void main(String[] args) {
        maxOfUncomparableCollection();
    }
    
    static void maxOfUncomparableCollection() {
        List<EntityUncomparable> entities = Arrays.asList(new EntityUncomparable(1), new EntityUncomparable(0));
        EntityUncomparable max = Collections.max(entities, new EntityComparator());
        System.err.println(max);
    }
    
    
}

class EntityComparable implements Comparable<EntityComparable> {
    int id;

    public EntityComparable(int id) { this.id = id; }   

    @Override
    public int compareTo(EntityComparable o) {
        return this.id - o.id;
    }

    @Override
    public String toString() { return "EntityComparable{" + "id=" + id + '}'; }
}

class EntityUncomparable {
    int id;

    public EntityUncomparable(int id) { this.id = id; }   

    @Override
    public String toString() { return "EntityNotComparable{" + "id=" + id + '}'; }   
}

class EntityComparator implements Comparator<EntityUncomparable> {

    @Override
    public int compare(EntityUncomparable o1, EntityUncomparable o2) {
        return o1.id - o2.id;
    }
}
