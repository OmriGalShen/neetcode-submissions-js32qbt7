class PrefixTree {
    TrieNode head;

    private static class TrieNode {
        private Map<Character, TrieNode> children = new HashMap<>();
        private boolean isEndOfWord;
    }

    public PrefixTree() {
        this.head = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.head;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.head;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isEndOfWord;
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
