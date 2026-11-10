class Solution {
    // def:  N - n,
    // time: O(N)
    // space: O(N)
    public int climbStairs(int n) {
        // guard
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int prev1 = 2; // ways to reach i-1
        int prev2 = 1; // ways to reach i-2
        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
