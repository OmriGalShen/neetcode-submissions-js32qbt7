class LRUCache {
    int cap;
    Map<Integer, Node> keyToNode;
    Node head;
    Node tail;

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.keyToNode = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (!this.keyToNode.containsKey(key)) {
            return -1;
        }
        Node node = this.keyToNode.get(key);
        this.remove(node);
        this.addMru(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(this.keyToNode.containsKey(key)){
            Node node = this.keyToNode.get(key);
            node.value = value;
            this.remove(node);
            this.addMru(node);
        } else{
            Node node = new Node(key, value);
            this.keyToNode.put(key, node);
            this.addMru(node);
            if(this.keyToNode.size() > this.cap){
                Node toRemove = this.head.next;
                this.keyToNode.remove(toRemove.key);
                this.remove(toRemove);
            }
        }
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addMru(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
}
