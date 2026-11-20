/*
N - s.length

time: O(N^2)
space: O(1)
*/
class Solution {
    public int countSubstrings(String s) {
        // guard
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            // odd
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
            // even
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}
