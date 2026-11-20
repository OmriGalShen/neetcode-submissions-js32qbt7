class Solution {
    /*
    time: O(N!/((N-K)!*K!) * K)
    space: output O(N!/((N-K)!*K!) * K), aux K
    */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int i, int n, int k, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j <= n - (k-curr.size()) + 1; j++) {
            curr.add(j);
            backtrack(j + 1, n, k, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}