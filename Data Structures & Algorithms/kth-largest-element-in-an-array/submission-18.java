class Solution {
    private final Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int l, int r) {
        if (l >= r) {
            return nums[l];
        }
        int pivotIndex = partition(nums, l, r);
        if (pivotIndex == nums.length - k) {
            return nums[pivotIndex];
        } else if (pivotIndex < nums.length - k + 1) {
            l = pivotIndex + 1;
        } else {
            r = pivotIndex - 1;
        }
        return quickSelect(nums, k, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = l + rand.nextInt(r - l + 1);
        swap(nums, pivot, r);
        int i = l;
        for (int j = l; j < r; j++) {
            if (nums[j] <= nums[r]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, r, i);
        return i;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}