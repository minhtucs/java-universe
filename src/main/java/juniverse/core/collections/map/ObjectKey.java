package juniverse.core.collections.map;

/**
 * @author tunm2
 */
public class ObjectKey {
    private int id;
    private String name;
    private boolean flag;

    public ObjectKey() {
    }
    
    public ObjectKey(int id, String name, boolean flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
//        hash = 31 * hash + Objects.hashCode(this.name);
//        hash = 31 * hash + (this.flag ? 1 : 0);
        return hash;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final ObjectKey other = (ObjectKey) obj;
//        if (this.id != other.id) {
//            return false;
//        }
//        if (!Objects.equals(this.name, other.name)) {
//            return false;
//        }
//        if (this.flag != other.flag) {
//            return false;
//        }
//        
//        return true;
//    }
    
    
}
