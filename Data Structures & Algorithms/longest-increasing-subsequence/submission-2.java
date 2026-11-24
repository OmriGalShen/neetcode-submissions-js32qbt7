class Solution {
    /*
    N - nums.length

    dp[i] = length of the longest strictly increasing subsequence ending at nums[i]
    0 <= i <= N

    recursive form
    dp[i] = 1 + max(dp[j]) for all 0 <= j < i where nums[j] < nums[i]
            (or 1 if no such j exists)

    base case:
    dp[0 <= i < N] = 1

    result
    max(dp[0],...,dp[N-1])

    time: O(N)
    space: O(N)
    */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i=1;i< n;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int result = 0;
        for (int val : dp) {
            result = Math.max(result, val);
        }
        return result;
    }
}
