class Solution {
    public int subarraySum(int[] nums, int k) {
        int currSum = 0;
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        int res = 0;
        for (int num : nums) {
            currSum += num;
            int diff = currSum - k;
            res += sumToCount.getOrDefault(diff, 0);
            sumToCount.put(currSum, sumToCount.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }
}