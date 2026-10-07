class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }

        Arrays.sort(counts);
        int maxFreq = counts[25];
        int idle = (maxFreq - 1) * n;
        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(maxFreq - 1, counts[i]);
        }
        return Math.max(idle, 0) + tasks.length;
    }
}


