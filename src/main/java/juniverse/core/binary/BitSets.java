package juniverse.core.binary;

/**
 *
 * @author tunm2
 */
public class BitSets {
    
    static final int WORD_SIZE = 64;
    
    private long[] words;
    private int cardinality;
    
    public BitSets(int nBits) {
        int nWords = nBits / WORD_SIZE;
        if (nBits % WORD_SIZE != 0) {
            nWords += 1;
        }
        this.words = new long[nWords];
    }
    
    public void set(int bitIndex) {
        if (!get(bitIndex)) {
            cardinality++;
        }
        int iWord = findWord(bitIndex);
        int iBit = findBitSlotInWord(bitIndex);
        long word = words[iWord];
        words[iWord] = word | (1 << iBit);
    }
    
    public void clear(int bitIndex) {
        if (get(bitIndex)) {
            cardinality--;
        }
        int iWord = findWord(bitIndex);
        int iBit = findBitSlotInWord(bitIndex);
        long word = words[iWord];
        words[iWord] = word & ~(1 << iBit);
    }
    
    public boolean get(int bitIndex) {
        int iWord = findWord(bitIndex);
        int iBit = findBitSlotInWord(bitIndex);
        long word = words[iWord];
        return (word & (1 << iBit)) != 0;
    }
    
    public int cardinality() {
        return cardinality;
    }
    
    private int findWord(int bitIndex) {
        return bitIndex / WORD_SIZE;
    }
    
    private int findBitSlotInWord(int bitIndex) {
        return bitIndex % WORD_SIZE;
    }
 
    public static void main(String[] args) {
        BitSets bs = new BitSets(1000000);
        int k = 100;
        System.err.println("initial: " + bs.get(k));
        bs.set(k);
        System.err.println("after set: " + bs.get(k));
        bs.clear(k);
        System.err.println("after clear: " + bs.get(k));
    }
}