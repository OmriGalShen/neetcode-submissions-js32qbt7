class Solution {
    // time: O*(N^2)
    // space: O(1)
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int bestL = -1;
        for (int i = 0; i < n; i++) {
            // odd
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                int len = r - l + 1;
                if (len > maxLen) {
                    maxLen = len;
                    bestL = l;
                }
                l--;
                r++;
            }
            // even
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                int len = r - l + 1;
                if (len > maxLen) {
                    maxLen = len;
                    bestL = l;
                }
                l--;
                r++;
            }
        }

        return s.substring(bestL, bestL + maxLen);
    }
}
