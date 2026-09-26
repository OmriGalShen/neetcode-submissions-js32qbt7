class Solution {
    record Quarter(int r, int c) {}
    ;

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Quarter, Set<Integer>> quarters = new HashMap<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int val = board[r][c];
                if (val == '.') {
                    continue;
                }
                rows.putIfAbsent(r, new HashSet<>());
                if (rows.get(r).contains(val)) {
                    return false;
                }
                rows.get(r).add(val);
                cols.putIfAbsent(c, new HashSet<>());
                if (cols.get(c).contains(val)) {
                    return false;
                }
                cols.get(c).add(val);
                Quarter q = new Quarter(r / 3, c / 3);
                quarters.putIfAbsent(q, new HashSet<>());
                if (quarters.get(q).contains(val)) {
                    return false;
                }
                quarters.get(q).add(val);
            }
        }
        return true;
    }
}
