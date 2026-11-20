class Solution {
    /*
    N - nums.length
    T - target
    time:
    space:
    */
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, 0, new ArrayList<>(), target, result);
        return result;
    }

    private void backtrack(int[] nums, int i, int currSum, List<Integer> curr, int target,
        List<List<Integer>> result) {
        if (currSum > target) {
            return;
        }
        if (currSum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (currSum + nums[j] > target) {
                break;
            }
            curr.add(nums[j]);
            backtrack(nums, j, currSum + nums[j], curr, target, result);
            curr.remove(curr.size() - 1);
        }
    }
}
