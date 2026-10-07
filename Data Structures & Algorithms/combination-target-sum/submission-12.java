class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, target, 0, new ArrayList<>(), res);
        return res;

    }

    public void backtrack(int[] nums, int target, int i, List<Integer> current, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || i >= nums.length) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (nums[j] > target) {
                break;
            }
            current.add(nums[j]);
            backtrack(nums, target - nums[j], j, current, res);
            current.remove(current.size() - 1);
        }
    }
}