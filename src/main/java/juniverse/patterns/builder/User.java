package juniverse.patterns.builder;

/**
 *
 * @author Tu Nguyen
 */
public class User {
    
    private final String name;
    private final long dob;
    private final byte gender;
    private final long phone;
    private final String password;
    private final String address;
    private final String job;
    
    private User(UserBuilder builder) {
        this.name = builder.name;
        this.dob = builder.dob;
        this.gender = builder.gender;
        this.phone = builder.phone;
        this.password = builder.password;
        this.address = builder.address;
        this.job = builder.job;
    }
    
    public static class UserBuilder {
        private String name;
        private long dob;
        private byte gender;
        private long phone;
        private String password;
        private String address;
        private String job;

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder dob(long dob) {
            this.dob = dob;
            return this;
        }

        public UserBuilder gender(byte gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder phone(long phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder job(String job) {
            this.job = job;
            return this;
        }
           
        public User build() {
            return new User(this);
        }
    }

    public String getName() {
        return name;
    }

    public long getDob() {
        return dob;
    }

    public byte getGender() {
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
