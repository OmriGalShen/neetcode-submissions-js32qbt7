public class LRUCache {
    Node head;
    Node tail;
    int cap;
    Map<Integer, Node> keyToNode;

    static class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        cap = capacity;
        keyToNode = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        Node node = keyToNode.get(key);
        removeNode(node);
        addToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node;
        if (!keyToNode.containsKey(key)) {
            node = new Node();
        } else {
            node = keyToNode.get(key);
            removeNode(node);
        }
        node.val = value;
        node.key = key;
        addToTail(node);
        keyToNode.put(key, node);
        if (keyToNode.size() > cap) {
            keyToNode.remove(head.next.key);
            removeNode(head.next);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}
