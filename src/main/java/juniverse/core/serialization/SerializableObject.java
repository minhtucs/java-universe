package juniverse.core.serialization;

import java.io.Serializable;

public class SerializableObject implements Serializable{
    private static final long serialVersionUID = 1961924929364388363L;
    
    private int integer;
    private String string;
//    private long lon;
    
    public SerializableObject(int integer, String string) {
        this.integer = integer;
        this.string = string;
    }
    
    public int getInteger() {
        return integer;
    }
    public void setInteger(int integer) {
        this.integer = integer;
    }
    public String getString() {
        return string;
    }
    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "SerializableObject [integer=" + integer + ", string=" + string + "]";
    }
    
//    @Override
//    public String toString() {
//        return "SerializableObject [integer=" + integer + ", string=" + string + ", lon=" + lon + "]";
//    }
}
