class NumArray {
    private final int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            prefixSum[i] = total;
        }
    }

    public int sumRange(int left, int right) {
        int rightSum = prefixSum[right];
        int leftSum = (left == 0) ? 0 : prefixSum[left-1];
        return rightSum - leftSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */