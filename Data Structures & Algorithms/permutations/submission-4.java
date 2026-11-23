class Solution {
    // time: O(N!*N)
    // space: output O(N!*N), aux O(N)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), visited, result);
        return result;
    }

    private void backtrack(
        int[] nums, List<Integer> curr, boolean[] visited, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (visited[j]) {
                continue;
            }
            curr.add(nums[j]);
            visited[j] = true;
            backtrack(nums, curr, visited, result);
            curr.remove(curr.size() - 1);
            visited[j] = false;
        }
    }
}
