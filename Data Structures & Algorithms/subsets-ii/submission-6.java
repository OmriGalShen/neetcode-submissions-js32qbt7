class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> curr, List<List<Integer>> result){
        result.add(new ArrayList<>(curr));

        for(int j=i; j<nums.length;j++){
            if(j > i && nums[j] == nums[j-1]){
                continue;
            }
            curr.add(nums[j]);
            backtrack(nums, j+1, curr, result);
            curr.remove(curr.size()-1);
        }
    }
}
