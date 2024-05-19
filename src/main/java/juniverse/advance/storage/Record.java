package juniverse.advance.storage;

/**
 *
 * @author tunm2
 */
public class Record {
    
    Header header;
    byte[] key;
    byte[] value;
    
    static class Header {
        static final int SIZE = 17;
        
        boolean status;
        int rsize; // header + k + v
        int ksize;
        int vsize;
        int pnext;
    }
}
