class Solution {
    // time: O(N^N * N)
    // space: output O(N^N * N), aux O(N)
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Set<Integer> colsSet = new HashSet<>();
        Set<Integer> diagSet = new HashSet<>();
        Set<Integer> rightDiagSet = new HashSet<>();
        backtrack(0, n, new ArrayList<>(), colsSet, diagSet, rightDiagSet, result);
        return result;
    }

    private void backtrack(int r, int n, List<String> curr, Set<Integer> colsSet, Set<Integer> diagSet,
        Set<Integer> rightDiagSet, List<List<String>> result) {
        if (r == n) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (colsSet.contains(c) || diagSet.contains(r-c) || rightDiagSet.contains(r+c)) {
                continue;
            }
            colsSet.add(c);
            diagSet.add(r-c);
            rightDiagSet.add(r+c);
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(".");
            }
            sb.setCharAt(c, 'Q');
            curr.add(sb.toString());
            backtrack(r+1, n, curr, colsSet, diagSet, rightDiagSet, result);
            curr.remove(curr.size()-1);
            colsSet.remove(c);
            diagSet.remove(r-c);
            rightDiagSet.remove(r+c);
        }
    }
}
