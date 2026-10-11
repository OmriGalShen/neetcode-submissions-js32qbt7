class Solution {
    private int[] prefixSum;
    private Random rand = new Random();

    public Solution(int[] w) {
        this.prefixSum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            if (i == 0) {
                prefixSum[i] = w[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + w[i];
            }
        }
    }

    public int pickIndex() {
        int l = 0, r = prefixSum.length-1;
        int total = prefixSum[prefixSum.length - 1];
        int target = rand.nextInt(total) + 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (prefixSum[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */