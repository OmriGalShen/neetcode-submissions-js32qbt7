class Solution {
    private int[] w;
    private int total;
    private Random random = new Random();

    public Solution(int[] w) {
        this.w = w;
        this.total = 0;
        for (int weight : w) {
            this.total += weight;
        }
    }

    public int pickIndex() {
        int targetWeight = random.nextInt(this.total + 1);
        int i = 0;
        int sum = 0;
        for (int weight : this.w) {
            if (targetWeight >= sum && targetWeight <= sum + weight) {
                return i;
            }
            sum += weight;
            i++;
        }
        return i;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */