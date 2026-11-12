class Solution {
    // N - nums.length
    // time: O(2^N * N)
    // space: aux O(N) + output O(2^N * N)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));
        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            backtrack(nums, j + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
