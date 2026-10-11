class LRUCache {
    Node head;
    Node tail;
    int cap;
    Map<Integer, Node> keyToNode;

    private static class Node {
        int val;
        int key;
        Node next;
        Node prev;
    }

    public LRUCache(int capacity) {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.cap = capacity;
        this.keyToNode = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        Node node = keyToNode.get(key);
        removeNode(node);
        addNodeToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node;
        if (keyToNode.containsKey(key)) {
            node = keyToNode.get(key);
            removeNode(node);
        } else {
            node = new Node();
        }
        node.key = key;
        node.val = value;
        addNodeToTail(node);
        keyToNode.put(key, node);
        if (keyToNode.size() > cap) {
            Node nodeToRemove = head.next;
            keyToNode.remove(nodeToRemove.key);
            removeNode(nodeToRemove);
        }
    }

    private void addNodeToTail(Node node) {
        node.prev = this.tail.prev;
        node.next = this.tail;
        this.tail.prev.next = node;
        this.tail.prev = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
