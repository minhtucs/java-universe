package juniverse.patterns.builder.bad1;

/**
 * Constructor with multiple arguments.
 * 
 * Problem: confusing and unreadable
 * 
 * @author Tu Nguyen
 */
public class User {
    
    private String name;
    private long dob;
    private boolean gender;
    private long phone;
    private String password;
    private String address;
    private String job;

    public User() {
    }

    public User(String name, long dob, boolean gender, long phone, 
        String password, String address, String job) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public long getDob() {
        return dob;
    }

    public boolean isGender() {
        return gender;
    }

    public long getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getJob() {
        return job;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", dob=" + dob + ", gender=" + gender + ", phone=" + phone + ", password=" + password + ", address=" + address + ", job=" + job + '}';
    }

}
