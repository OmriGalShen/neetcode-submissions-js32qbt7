class Solution {
    private Random rand = new Random();
    // time: O(N) avg, O(N^2) worst
    // space: O(1)
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int target = n - k;
        while (l <= r) {
            int pivot = partition(nums, l, r);
            if (pivot == target) {
                return nums[pivot];
            } else if (pivot < target) {
                l = pivot + 1;
            } else {
                r = pivot - 1;
            }
        }
        return -1;
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
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
