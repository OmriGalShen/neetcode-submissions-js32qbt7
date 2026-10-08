class Solution {
    List<List<String>> res = new ArrayList<>();
    Set<Integer> row = new HashSet<>();
    Set<Integer> col = new HashSet<>();
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
        StringBuilder rowSb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            rowSb.append(".");
        }
        for (int c = 0; c < n; c++) {
            if (col.contains(c) || row.contains(r) || diag1.contains(r - c)
                || diag2.contains(r + c)) {
                continue;
            }
            rowSb.replace(c, c+1, "Q");
            board.add(rowSb.toString());
            row.add(r);
            col.add(c);
            diag1.add(r - c);
            diag2.add(r + c);
            backtrack(r + 1, board);
            board.remove(board.size() - 1);
            rowSb.replace(c, c+1, ".");
            row.remove(r);
            col.remove(c);
            diag1.remove(r - c);
            diag2.remove(r + c);
        }
    }
}
