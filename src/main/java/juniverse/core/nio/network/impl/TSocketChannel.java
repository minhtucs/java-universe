package juniverse.core.nio.network.impl;

public class TSocketChannel extends TSelectableChannel {

    public static TSocketChannel open() {
        return new TSocketChannel();
    }
    
}
