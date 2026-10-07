class Solution {
    private final Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int pivotIndex = partition(nums, left, right);
        int target = nums.length - k;

        if (pivotIndex == target) {
            return nums[pivotIndex];
        } else if (pivotIndex < target) {
            left = pivotIndex + 1;
        } else {
            right = pivotIndex - 1;
        }
        return quickSelect(nums, k, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivotIndex = left + rand.nextInt(right - left + 1);
        swap(nums, pivotIndex, right);
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] <= nums[right]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
