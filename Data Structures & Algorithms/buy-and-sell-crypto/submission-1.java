class Solution {
    // time: O(N)
    // space: O(1)
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int maxProfit = 0;
        int currMin = prices[0];
        for(int i=1;i<prices.length;i++){
            int profit = Math.max(0, prices[i] - currMin);
            maxProfit = Math.max(maxProfit, profit);
            currMin = Math.min(currMin, prices[i]);
        }
        return maxProfit;
    }
}
