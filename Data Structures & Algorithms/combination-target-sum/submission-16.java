class Solution {
    // N - nums.length, M -min(nums), T - target
    // time: O(2 ^ (T/M) * (T/M))
    // space: output O(2 ^ (T/M) * (T/M)), aux O(N)
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, 0, new ArrayList<>(), target, result);
        return result;
    }

    private void backtrack(
        int[] nums, int i, int sum, List<Integer> curr, int target, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (sum + nums[j] > target) {
                break;
            }
            curr.add(nums[j]);
            backtrack(nums, j, sum + nums[j], curr, target, result);
            curr.remove(curr.size() - 1);
        }
    }
}
