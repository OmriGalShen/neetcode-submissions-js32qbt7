class LRUCache {
    int cap;
    Node head;
    Node tail;
    Map<Integer, Node> keyToNode = new HashMap<>();

    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
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
            node.val = value;
            removeNode(node);
            addNodeToTail(node);
            return;
        }
        node = new Node();
        node.key = key;
        node.val = value;
        addNodeToTail(node);
        keyToNode.put(key, node);
        if (keyToNode.size() > cap) {
            Node nodeToRemove = this.head.next;
            keyToNode.remove(nodeToRemove.key);
            removeNode(nodeToRemove);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNodeToTail(Node node) {
        node.prev = this.tail.prev;
        node.next = this.tail;
        this.tail.prev.next = node;
        this.tail.prev = node;
    }
}
