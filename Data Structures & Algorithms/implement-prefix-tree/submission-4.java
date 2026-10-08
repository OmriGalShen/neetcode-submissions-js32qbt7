class PrefixTree {
    TrieNode head;

    private static class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private boolean isEndOfWord;
    }

    public PrefixTree() {
        this.head = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.head;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.head;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.head;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}
