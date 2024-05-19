package juniverse.core.nio;

import java.util.concurrent.atomic.AtomicReference;

public class NIOStack {
    private final AtomicReference<Element> head = new AtomicReference<Element>(null);

    public void push(String value) {
        Element newElement = new Element(value);

        while (true) {
            Element currentHead = head.get();
            newElement.next = currentHead;

            // Trying to set the new element as the head
            if (head.compareAndSet(currentHead, newElement)) {
                return;
            }
        }
    }

    public String pop() {
        while (true) {
            Element currentHead = head.get();

            // The stack is empty
            if (currentHead == null) {
                return null;
            }

            Element newHead = currentHead.next;

            // Trying to set the new element as the head
            if (head.compareAndSet(currentHead, newHead)) {
                return currentHead.value;
            }
        }
    }

    private static final class Element {
        private final String value;
        private Element next;

        private Element(String value) {
            this.value = value;
        }
    }
}
