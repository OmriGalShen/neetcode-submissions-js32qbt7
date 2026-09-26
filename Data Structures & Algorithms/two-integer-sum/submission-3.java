class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (valToIndex.containsKey(target - val)) {
                return new int[] {valToIndex.get(target - val), i};
            }
            valToIndex.put(val, i);
        }
        return null;
    }
}
