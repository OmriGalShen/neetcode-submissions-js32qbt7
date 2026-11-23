class Solution {
    // K - tasks.length
    // time: O(K*Log(K))
    // space: O()
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        int maxFreq = 0;
        for (char c : tasks) {
            counts[c - 'A']++;
            maxFreq = Math.max(maxFreq, counts[c - 'A']);
        }
        int maxCount = 0;
        for (int count : counts) {
            if (count == maxFreq) {
                maxCount++;
            }
        }
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount);
    }
}
