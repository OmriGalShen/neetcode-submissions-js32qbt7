class Solution {
    TrieNode head;
    List<String> res;
    char[][] board;
    int N;
    int M;

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
        int refCount = 0;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.N = board.length;
        this.M = board[0].length;
        this.head = new TrieNode();
        this.res = new ArrayList<>();

        for (String s : words) {
            TrieNode curr = this.head;
            for (char c : s.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
                curr.refCount++;
            }
            curr.word = s;
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                backtrack(r, c, this.head);
            }
        }
        return res;
    }

    private int backtrack(int r, int c, TrieNode node) {
        if (r < 0 || r >= N || c < 0 || c >= M) {
            return 0;
        }
        char ch = board[r][c];
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return 0;
        }
        node = node.children[ch - 'a'];
        if (node.refCount <= 0) {
            return 0;
        }
        int matches = 0;
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
            matches++;
        }
        board[r][c] = '#';
        matches += backtrack(r + 1, c, node);
        matches += backtrack(r - 1, c, node);
        matches += backtrack(r, c + 1, node);
        matches += backtrack(r, c - 1, node);
        node.refCount -= matches;
        board[r][c] = ch;
        return matches;
    }
}
