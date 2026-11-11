class Solution {
    // def: 
    // dp[i] = minimum cost to get to floor i
    // dp[i] = min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
    // base case: d[0] = 0, dp[1]=0
    // time: 
    // space: 
    public int minCostClimbingStairs(int[] cost) {
        // guard 
        if(cost == null || cost.length < 2){
            return 0;
        }
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int step = 2; step <= n; step++){
            dp[step] = Math.min(dp[step-1]+cost[step-1], dp[step-2]+cost[step-2]);
        }
        return dp[n];
    }
}

// [1,2,3], [0,1,0,0,0]