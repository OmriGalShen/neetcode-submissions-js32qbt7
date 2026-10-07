class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subsets(nums, 0, current, res);
        return res;
    }

    private void subsets(int[] nums, int i, List<Integer> current, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[i]);
        subsets(nums, i + 1, current, res);
        current.remove(current.size() - 1);
        subsets(nums, i + 1, current, res);
    }
}