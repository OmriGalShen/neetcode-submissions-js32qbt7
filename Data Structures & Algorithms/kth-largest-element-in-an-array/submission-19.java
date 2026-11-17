class Solution {
    private Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int targetIndex = n - k;
        int l = 0, r = n - 1;
        while (l <= r) {
            int pivot = partition(nums, l, r);
            if (pivot < targetIndex) {
                l = pivot + 1;
            } else if (pivot > targetIndex) {
                r = pivot - 1;
            } else {
                return nums[pivot];
            }
        }
        return -1;
    }

    private int partition(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
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
