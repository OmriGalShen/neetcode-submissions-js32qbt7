class Solution {
    /*
    def: N - nums.length
    time: O(N! * N)
    space: output(N! *N) + O(N) aux
    */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        // guard
        if (nums == null) {
            return result;
        }
        backtrack(new ArrayList<>(), used, nums, result);
        return result;
    }

    private void backtrack(
        List<Integer> curr, boolean[] used, int[] nums, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            curr.add(nums[i]);
            used[i] = true;
            backtrack(curr, used, nums, result);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}
