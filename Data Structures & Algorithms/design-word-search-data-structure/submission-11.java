class WordDictionary {
    TrieNode head;

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    public WordDictionary() {
        this.head = new TrieNode();
    }

    public void addWord(String word) {
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
        return search(word, 0, this.head);
    }

    private boolean search(String word, int i, TrieNode node) {
        if (i == word.length()) {
            return node.isEndOfWord;
        }
        char c = word.charAt(i);
        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (node.children[j] != null && search(word, i + 1, node.children[j])) {
                    return true;
                }
            }
            return false;
        } else if (node.children[c - 'a'] == null) {
            return false;
        } else {
            return search(word, i + 1, node.children[c - 'a']);
        }
    }
}
