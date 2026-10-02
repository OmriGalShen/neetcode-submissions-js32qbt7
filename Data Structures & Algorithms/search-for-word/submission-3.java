class Solution {
    int N;
    int M;
    String word;
    char[][] board;

    record Cell(int row, int col) {}

    public boolean exist(char[][] board, String word) {
        this.N = board.length;
        this.M = board[0].length;
        this.board = board;
        this.word = word;

        for (int r = 0; r < this.N; r++) {
            for (int c = 0; c < this.M; c++) {
                Set<Cell> set = new HashSet<>();
                if (exist(r, c, set, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(int r, int c, Set<Cell> set, int i) {
        if (r < 0 || r >= this.N || c < 0 || c >= this.M || set.contains(new Cell(r, c))) {
            return false;
        }
        if (this.board[r][c] != this.word.charAt(i) || i == this.word.length()) {
            return false;
        }
        i++;
        if(i == this.word.length()){
            return true;
        }
        set.add(new Cell(r, c));
        boolean v1 = exist(r + 1, c, set, i);
        boolean v2 = exist(r - 1, c, set, i);
        boolean v3 = exist(r, c + 1, set, i);
        boolean v4 = exist(r, c - 1, set, i);
        set.remove(new Cell(r, c));
        return v1 || v2 || v3 || v4;
    }
}
