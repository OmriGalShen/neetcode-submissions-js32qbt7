class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] tCounts = new int[128];
        int[] sCounts = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tCounts[t.charAt(i)]++;
        }
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int startIndex = 0;
        int match = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            sCounts[c]++;
            if (sCounts[c] <= tCounts[c]) {
                match++;
            }
            while (match == t.length()) {
                if (minLen == -1 || (r - l + 1) < minLen) {
                    minLen = (r - l + 1);
                    startIndex = l;
                }
                sCounts[s.charAt(l)]--;
                if (tCounts[s.charAt(l)] > 0 && sCounts[s.charAt(l)] < tCounts[s.charAt(l)]) {
                    match--;
                }
                l++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
