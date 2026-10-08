class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, used, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(
        int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> res) {
        if (current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, res);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
