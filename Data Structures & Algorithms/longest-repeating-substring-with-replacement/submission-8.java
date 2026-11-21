class Solution {
    // time: O(N)
    // space: O(1)
    public int characterReplacement(String s, int k) {
        int l = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int[] counts = new int[26];
        for (int r = 0; r < s.length(); r++) {
            counts[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, counts[s.charAt(r) - 'A']);
            while (r - l + 1 - maxFreq > k) {
                counts[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
