class Solution {
    // time: O(N)
    // space: output O(N) + aux O(1)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int prefixAcc = 1;
        for(int i=0;i<n;i++){
            result[i] = prefixAcc;
            prefixAcc *= nums[i];
        }
        int suffixAcc = 1;
        for(int i=n-1;i>=0;i--){
            result[i] *= suffixAcc;
            suffixAcc *= nums[i];
        }
        return result;
    }
}  
