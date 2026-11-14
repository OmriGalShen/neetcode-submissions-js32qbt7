class Solution {
    /*
    def: N - nums.length
    time: O()
    */
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int target, int i, int currSum, List<Integer> curr,
        List<List<Integer>> result) {
        if (currSum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (currSum > target) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (currSum + nums[j] > target) {
                break;
            }
            curr.add(nums[j]);
            backtrack(nums, target, j, currSum + nums[j], curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
