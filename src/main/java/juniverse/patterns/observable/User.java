package juniverse.patterns.observable;

/**
 *
 * @author tunm2
 */
public class User {
    
    public int id;
    public String name;
    public String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
    }
    
}
