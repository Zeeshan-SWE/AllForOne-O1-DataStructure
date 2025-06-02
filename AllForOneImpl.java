import java.util.*;

class AllForOneImpl implements AllForOne {

    // Node represents a frequency bucket
    private static class Node {
        int freq;
        Set<String> keys;
        Node prev, next;

        Node(int freq) {
            this.freq = freq;
            this.keys = new HashSet<>();
        }
    }

    private Map<String, Node> keyToNode;
    private Node head, tail;

    public AllForOneImpl() {
        keyToNode = new HashMap<>();
        head = new Node(0); // dummy head
        tail = new Node(0); // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public void incrementKey(String key) {
        if (!keyToNode.containsKey(key)) {
            // Insert into freq 1 bucket
            Node freqOne = head.next;
            if (freqOne == tail || freqOne.freq != 1) {
                freqOne = insertAfter(head, new Node(1));
            }
            freqOne.keys.add(key);
            keyToNode.put(key, freqOne);
        } else {
            Node curr = keyToNode.get(key);
            Node next = curr.next;
            if (next == tail || next.freq != curr.freq + 1) {
                next = insertAfter(curr, new Node(curr.freq + 1));
            }
            next.keys.add(key);
            keyToNode.put(key, next);

            curr.keys.remove(key);
            if (curr.keys.isEmpty()) remove(curr);
        }
    }

    @Override
    public void decrementKey(String key) {
        if (!keyToNode.containsKey(key)) return;

        Node curr = keyToNode.get(key);
        if (curr.freq == 1) {
            curr.keys.remove(key);
            keyToNode.remove(key);
        } else {
            Node prev = curr.prev;
            if (prev == head || prev.freq != curr.freq - 1) {
                prev = insertAfter(curr.prev, new Node(curr.freq - 1));
            }
            prev.keys.add(key);
            keyToNode.put(key, prev);

            curr.keys.remove(key);
        }

        if (curr.keys.isEmpty()) remove(curr);
    }

    @Override
    public String getMaxKey() {
        if (tail.prev == head) return "";
        return tail.prev.keys.iterator().next();
    }

    @Override
    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.keys.iterator().next();
    }

    // Insert a new node after a given node
    private Node insertAfter(Node node, Node newNode) {
        newNode.next = node.next;
        newNode.prev = node;
        node.next.prev = newNode;
        node.next = newNode;
        return newNode;
    }

    // Remove a node from the list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
