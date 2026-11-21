class Solution {
    // time: O(n)
    // space: O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valToInd = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (valToInd.containsKey(diff)) {
                return new int[] {valToInd.get(diff), i};
            }
            valToInd.put(nums[i], i);
        }
        return new int[0];
    }
}
