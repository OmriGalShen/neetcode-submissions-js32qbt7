class Solution {
    int k;
    int[] nums;
    int targetSum;
    boolean[] picked;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.k = k;
        this.nums = nums;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        this.targetSum = sum / k;
        for (int num : nums) {
            if (num > targetSum) {
                return false;
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        picked = new boolean[nums.length];
        return canPartitionKSubsets(0, 0, k);
    }

    private boolean canPartitionKSubsets(int i, int currentSum, int k) {
        if (k == 0) {
            return true;
        }
        if (currentSum == targetSum) {
            return canPartitionKSubsets(0, 0, k - 1);
        }
        for (int j = i; j < nums.length; j++) {
            if (!picked[j] && currentSum + nums[j] <= targetSum) {
                picked[j] = true;
                if (canPartitionKSubsets(j + 1, currentSum + nums[j], k)) {
                    return true;
                }
                picked[j] = false;
            }
        }
        return false;
    }
}