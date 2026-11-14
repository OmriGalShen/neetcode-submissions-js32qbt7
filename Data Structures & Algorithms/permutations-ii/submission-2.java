class Solution {
    /*
    def: N - nums.length
    time: O(N! * N)
    space: O(N! * N) output + O(N)
    */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // guard
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(new ArrayList<>(), nums, used, result);
        return result;
    }

    private void backtrack(
        List<Integer> curr, int[] nums, boolean[] used, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            curr.add(nums[i]);
            used[i] = true;
            backtrack(curr, nums, used, result);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}