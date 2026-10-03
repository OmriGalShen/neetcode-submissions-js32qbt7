class PrefixTree {
    TrieNode head;

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean end;
    }

    public PrefixTree() {
        this.head = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.head;
        for (char c : word.toCharArray()) {
            TrieNode node = curr.children.getOrDefault(c, new TrieNode());
            curr.children.put(c, node);
            curr = node;
        }
        curr.end = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.head;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.head;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }
}
