class LRUCache {
    private Node head;
    private Node tail;
    private int cap;
    private Map<Integer, Node> keyToNode;
    private int size;

    private static class Node {
        int key;
        int val;
        Node next;
        Node prev;
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        head = new Node();
        tail = new Node();
        keyToNode = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        size = 0;
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
            size++;
        }
        node.key = key;
        node.val = value;
        addNodeToTail(node);
        keyToNode.put(key, node);
        if (size > cap) {
            size--;
            Node nodeToRemove = head.next;
            keyToNode.remove(nodeToRemove.key);
            removeNode(nodeToRemove);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNodeToTail(Node node) {
        Node temp = tail.prev;
        temp.next = node;
        node.prev = temp;
        node.next = tail;
        tail.prev = node;
    }
}
