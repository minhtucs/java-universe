package juniverse.core.nio.network.impl;

public class TSelectionKey {
    
    public static final int OP_READ        = 1 << 0;
    public static final int OP_WRITE       = 1 << 1;
    public static final int OP_CONNECT     = 1 << 2;
    public static final int OP_ACCEPT      = 1 << 3;
    
    /** Operations set */
    private int interestOps;
    
    private TSelector selector;
    private TSelectableChannel channel;
    
    public int interestOps() {
        return interestOps;
    }
    
    public void interestOps(int ops) {
        this.interestOps = ops;
    }
    
    public boolean isReadable() {
        return (interestOps & OP_READ) != 0;
    }
    
    public boolean isWritable() {
        return (interestOps & OP_WRITE) != 0;
    }
    
    public boolean isConnectable() {
        return (interestOps & OP_CONNECT) != 0;
    }
    
    public boolean isAcceptable() {
        return (interestOps & OP_ACCEPT) != 0;
    }
}
