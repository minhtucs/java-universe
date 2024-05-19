package juniverse.solid.srp.modem.good;

/**
 *
 * @author Tu Nguyen
 */
public interface ModemDataChannel {
    
    void send(byte data);
    byte receive();
    
}
