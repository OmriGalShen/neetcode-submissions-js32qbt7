class Solution {
    // N - nums.length
    // time: O()
    // space: O(2^N)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> curr, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        backtrack(nums, i + 1, curr, result);
        curr.remove(curr.size() - 1);
        backtrack(nums, i + 1, curr, result);
    }
}
