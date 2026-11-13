class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];

        int l = 0;
        int maxLen = 0;
        for (int r = 0; r < s.length(); r++) {
            counts[s.charAt(r) - 'A']++;
            int maxFreq = 0;
            for (int i = 0; i < 26; i++) {
                maxFreq = Math.max(maxFreq, counts[i]);
            }
            while (r - l + 1 - maxFreq > k) {
                counts[s.charAt(l)-'A']--;
                l++;
                maxFreq = 0;
                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, counts[i]);
                }
            }
            maxLen = Math.max(r-l+1, maxLen);
        }
        return maxLen;
    }
}
