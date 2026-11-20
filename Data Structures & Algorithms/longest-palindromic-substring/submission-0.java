/*
N - s.length

ababd -> aba

time: O(n^2)
space: O(1)
*/
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 1;
        int bestL = 0, bestR = 0;
        for (int i = 0; i < n; i++) {
            // odd palindormes
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    bestL = l;
                    bestR = r;
                }
                l--;
                r++;
            }

            // even palindromes
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    bestL = l;
                    bestR = r;
                }

                l--;
                r++;
            }
        }
        return s.substring(bestL, bestR+1);
    }
}
