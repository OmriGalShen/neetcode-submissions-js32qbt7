class Solution {
    // N - candidates.length, M = min(candidates), T = target
    // time:
    // space:
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, 0, new ArrayList<>(), target, result);
        return result;
    }

    private void backtrack(int[] candidates, int i, int sum, List<Integer> curr, int target,
        List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (sum + candidates[j] > target) {
                break;
            }
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            curr.add(candidates[j]);
            backtrack(candidates, j + 1, sum + candidates[j], curr, target, result);
            curr.remove(curr.size() - 1);
        }
    }
}
