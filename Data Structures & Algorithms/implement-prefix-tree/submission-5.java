class PrefixTree {
    private TrieNode root = new TrieNode();

    private static class TrieNode {
        TrieNode[] childern = new TrieNode[26];
        boolean isWord = false;
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.childern[index] == null) {
                curr.childern[index] = new TrieNode();
            }
            curr = curr.childern[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.childern[index] == null) {
                return false;
            }
            curr = curr.childern[index];
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (curr.childern[index] == null) {
                return false;
            }
            curr = curr.childern[index];
        }
        return true;
    }
}
