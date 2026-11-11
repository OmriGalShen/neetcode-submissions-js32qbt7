class Solution {
    // def: 
    // dp[i] = minimum cost to get to floor i
    // dp[i] = min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
    // base case: d[0] = 0, dp[1]=0
    // N - cost.length
    // time: O(N)
    // space: O(1)
    public int minCostClimbingStairs(int[] cost) {
        // guard 
        if(cost == null || cost.length < 2){
            return 0;
        }
        int n = cost.length;
        int prev1Step = 0;
        int prev2Steps = 0;
        for(int step = 2; step <= n; step++){
            int curr = Math.min(prev1Step+cost[step-1], prev2Steps+cost[step-2]);
            prev2Steps = prev1Step;
            prev1Step = curr;
        }
        return prev1Step;
    }
}