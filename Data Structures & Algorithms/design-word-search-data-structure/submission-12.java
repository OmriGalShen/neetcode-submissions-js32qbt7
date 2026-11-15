class WordDictionary {
    private final TrieNode root = new TrieNode();

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.word = word;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.word != null;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (search(word, index + 1, node.children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            return search(word, index + 1, node.children[c - 'a']);
        }
    }
}
