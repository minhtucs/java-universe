package juniverse.solid.srp.modem.bad;

/**
 *
 * @author Tu Nguyen
 */
public interface Modem {
    
    void dial();
    void hangup();
    void send(byte data);
    byte receive();
    
}
