package juniverse.core.java8.entity;

/**
 *
 * @author tunm2
 */
public class Entity {
    
    public int id;
    public String name;

    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    @Override
    public String toString() {
        return "Entity{" + "id=" + id + ", name=" + name + '}';
    }
    
}
