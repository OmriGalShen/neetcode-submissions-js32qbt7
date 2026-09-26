class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int currMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - currMin;
            res = Math.max(res, profit);
            currMin = Math.min(currMin, prices[i]);
        }
        return res;
    }
}
