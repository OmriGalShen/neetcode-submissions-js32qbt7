class Solution {
    TrieNode head;
    List<String> res = new ArrayList<>();
    char[][] board;
    int N;
    int M;

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.N = board.length;
        this.M = board[0].length;
        this.head = new TrieNode();

        for (String s : words) {
            TrieNode curr = this.head;
            for (char c : s.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
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

    private void backtrack(int r, int c, TrieNode node) {
        if (r < 0 || r >= N || c < 0 || c >= M) {
            return;
        }
        char ch = board[r][c];
        if (ch == '#' || node.children[ch-'a'] == null) {
            return;
        }
        node = node.children[ch - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        board[r][c] = '#';
        backtrack(r + 1, c, node);
        backtrack(r - 1, c, node);
        backtrack(r, c + 1, node);
        backtrack(r, c - 1, node);
        board[r][c] = ch;
    }
}
