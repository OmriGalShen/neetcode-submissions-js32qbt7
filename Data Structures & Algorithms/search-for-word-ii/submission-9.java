class Solution {
    List<String> res;
    int N;
    int M;
    char[][] board;
    TrieNode head;
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.res = new ArrayList<>();
        this.board = board;
        this.N = board.length;
        this.M = board[0].length;
        this.head = new TrieNode();
        for (String word : words) {
            TrieNode curr = head;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                bfs(r, c, head);
            }
        }
        return res;
    }

    private void bfs(int r, int c, TrieNode node) {
        if (node == null) {
            return;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            char ch = board[row][col];
            if (node.children[ch - 'a'] == null) {
                return;
            }
            node = node.children[ch - 'a'];
            if (node.word != null) {
                res.add(node.word);
                node.word = null;
            }
            board[row][col] = '#';
            for (int[] direction : directions) {
                int nr = row + direction[0];
                int nc = col + direction[1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && board[nr][nc] != '#') {
                    bfs(nr, nc, node);
                }
            }
            board[row][col] = ch;
        }
    }
}
