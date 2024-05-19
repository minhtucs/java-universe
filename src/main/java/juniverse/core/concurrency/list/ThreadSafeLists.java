package juniverse.core.concurrency.list;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author tunm2
 */
public class ThreadSafeLists {

    public static void main(String[] args) {
        Collections.synchronizedList(new ArrayList<>());
    }
    
}
