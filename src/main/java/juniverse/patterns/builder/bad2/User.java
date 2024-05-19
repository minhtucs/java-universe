package juniverse.patterns.builder.bad2;

/**
 * Setters implementation.
 * 
 * Problems:
 *  1. Construction is split across multiple calls, clients may see inconsistent states 
 *     of an instance. This is error prone.
 *  2. Cannot take advantage of immutable object
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDob() {
        return dob;
    }

    public void setDob(long dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", dob=" + dob + ", gender=" + gender + ", phone=" + phone + ", password=" + password + ", address=" + address + ", job=" + job + '}';
    }
 
}
