class Solution {
    /*
    def: N - nums.length
    time: O(2^N*N)
    space: O(2^N * N)
    */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            curr.add(nums[j]);
            backtrack(nums, j + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
