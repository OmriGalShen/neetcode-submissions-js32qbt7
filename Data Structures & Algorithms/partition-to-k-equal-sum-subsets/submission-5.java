class Solution {
    int[] nums;
    int targetSum;
    boolean[] picked;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        this.targetSum = sum / k;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            if (nums[i] > targetSum || nums[j] > targetSum) {
                return false;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        picked = new boolean[nums.length];
        return canPartitionKSubsets(0, 0, k);
    }

    private boolean canPartitionKSubsets(int i, int currentSum, int k) {
        if (k == 1) {
            return true;
        }
        if (currentSum == targetSum) {
            return canPartitionKSubsets(0, 0, k - 1);
        }
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1] && !picked[j - 1]) {
                continue;
            }
            if (!picked[j] && currentSum + nums[j] <= targetSum) {
                picked[j] = true;
                if (canPartitionKSubsets(j + 1, currentSum + nums[j], k)) {
                    return true;
                }
                picked[j] = false;
                if (currentSum == 0) {
                    return false;
                }
            }
        }
        return false;
    }
}