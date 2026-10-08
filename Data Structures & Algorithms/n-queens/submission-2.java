class Solution {
    List<List<String>> res = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag1 = new HashSet<>();
    Set<Integer> diag2 = new HashSet<>();
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        backtrack(0, new ArrayList<>());
        return res;
    }

    private void backtrack(int r, List<String> board) {
        if (r == n) {
            res.add(new ArrayList<>(board));
            return;
        }
        char[] row = new char[n];
        Arrays.fill(row, '.');
        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || diag1.contains(r - c) || diag2.contains(r + c)) {
                continue;
            }
            row[c] = 'Q';
            board.add(new String(row));
            cols.add(c);
            diag1.add(r - c);
            diag2.add(r + c);
            backtrack(r + 1, board);
            board.remove(board.size() - 1);
            row[c] = '.';
            cols.remove(c);
            diag1.remove(r - c);
            diag2.remove(r + c);
        }
    }
}
