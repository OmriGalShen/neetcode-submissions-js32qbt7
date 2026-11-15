class Solution {
    private TrieNode root;
    private char[][] board;
    private int N;
    private int M;
    private int maxLength = 0;
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.N = board.length;
        this.M = board[0].length;
        root = new TrieNode();
        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }
        List<String> result = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                dfs(r, c, root, result);
            }
        }
        return result;
    }

    private void dfs(int r, int c, TrieNode node, List<String> result) {
        char ch = board[r][c];
        if (ch == '.') {
            return;
        }
        node = node.children[ch - 'a'];
        if (node == null) {
            return;
        }
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        board[r][c] = '.';
        for (int[] direction : DIRECTIONS) {
            int nr = r + direction[0];
            int nc = c + direction[1];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                dfs(nr, nc, node, result);
            }
        }
        board[r][c] = ch;
    }
}
