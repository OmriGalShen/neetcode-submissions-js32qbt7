class Solution {
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
            visited[j] = true;
            curr.add(nums[j]);
            backtrack(nums, curr, visited, result);
            visited[j] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
