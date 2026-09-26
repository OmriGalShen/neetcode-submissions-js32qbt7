class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int[] counts = new int[26];
        int l = 0;
        int res = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            counts[c - 'A']++;
            maxFreq = Math.max(maxFreq, counts[c - 'A']);
            while (r - l + 1 - maxFreq > k) {
                counts[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
