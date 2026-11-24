class Solution {
    /*

    dp[i] = number of distinct ways to climb to get to level i
    0 <= i <= n

    dp[i] = dp[i-1] + dp[i-2]

    base case:
    dp[1] = 1
    dp[2] = 2

    result
    dp[n] 

    time: O(N)
    space: O(1)
    */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int countPrevPrev = 1;
        int countPrev = 2;
        for (int i = 3; i <= n; i++) {
            int curr = countPrevPrev + countPrev;
            countPrevPrev = countPrev;
            countPrev = curr;
        }
        return countPrev;
    }
}
