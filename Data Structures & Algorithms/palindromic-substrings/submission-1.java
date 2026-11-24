class Solution {
    // time: O*(N^2)
    // space: O(1)
    public int countSubstrings(String s) {
        int n = s.length();
        int paliCount = 0;
        for (int i = 0; i < n; i++) {
            // odd
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                paliCount++;
                l--;
                r++;
            }
            // even
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                paliCount++;
                l--;
                r++;
            }
        }

        return paliCount;
    }
}
