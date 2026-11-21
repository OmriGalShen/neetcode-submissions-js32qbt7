class Solution {
    // time:
    // space:
    public int characterReplacement(String s, int k) {
        int l = 0;
        int maxLen = 0;
        int[] counts = new int[26];
        for (int r = 0; r < s.length(); r++) {
            counts[s.charAt(r) - 'A']++;
            while (r - l + 1 - maxFreq(counts) > k) {
                counts[s.charAt(l)-'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    private int maxFreq(int[] counts) {
        int max = 0;
        for (int count : counts) {
            max = Math.max(max, count);
        }
        return max;
    }
}
