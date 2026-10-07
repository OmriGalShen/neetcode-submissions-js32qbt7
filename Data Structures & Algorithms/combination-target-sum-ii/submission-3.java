class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int i, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (candidates[j] > target) {
                break;
            }
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            curr.add(candidates[j]);
            backtrack(candidates, target - candidates[j], j + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}