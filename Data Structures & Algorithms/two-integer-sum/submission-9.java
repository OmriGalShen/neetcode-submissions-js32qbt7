class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            Integer j = valToIndex.get(diff);
            if (j != null) {
                return new int[] {j, i};
            }

            valToIndex.put(nums[i], i);
        }
        return new int[0];
    }
}
