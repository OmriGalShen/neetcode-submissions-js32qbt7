class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (valToIndex.containsKey(diff)) {
                int j = valToIndex.get(diff);
                return new int[] {j, i};
            }
            valToIndex.put(nums[i], i);
        }
        return new int[2];
    }
}
