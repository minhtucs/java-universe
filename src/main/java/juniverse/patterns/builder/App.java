package juniverse.patterns.builder;

/**
 *
 * @author Tu Nguyen
 */
public class App {
    
    public static void main(String[] args) {
        User user = new User.UserBuilder()
            .name("Tu Nguyen")
            .dob(System.currentTimeMillis())
            .gender((byte)1)
            .phone(1122334455L)
            .job("Software Engineer")
            .address("Ho Chi Minh City, Vietnam")
            .build();
     
        System.out.println(user);
    }
    
}
