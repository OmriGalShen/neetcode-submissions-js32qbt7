class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        combinationSum(nums, target, 0, new ArrayList<>(), res);
        return res;

    }

    public void combinationSum(int[] nums, int target, int i, List<Integer> current, List<List<Integer>> res) {
        if (target < 0 || i >= nums.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[i]);
        combinationSum(nums, target - nums[i], i, current, res);
        current.remove(current.size() - 1);
        combinationSum(nums, target, i + 1, current, res);
    }
}