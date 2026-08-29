
class Solution {
    int targetIndex;
    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        this.targetIndex = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int pivot_ind = l + random.nextInt(r-l+1);
        swap(nums, pivot_ind, r);
        int p = l;
        for(int i=l; i < r; i++){
            if(nums[i] <= nums[r]){
                swap(nums, i, p);
                p ++;
            }
        }
        swap(nums, p, r);
        if(p == targetIndex){
            return nums[p];
        }
        if(p < targetIndex){
            return quickSelect(nums,p+1,r);
        }else{
            return quickSelect(nums,l, p-1);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
