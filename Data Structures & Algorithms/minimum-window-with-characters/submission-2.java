class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int size = 'z'-'A'+1;
        int[] tCounts = new int[size];
        int[] sCounts = new int[size];
        for (int i = 0; i < t.length(); i++) {
            tCounts[t.charAt(i) - 'A']++;
        }
        int minLen = -1;
        int l = 0;
        int startIndex = 0;
        for (int r = 0; r < s.length(); r++) {
            sCounts[s.charAt(r) - 'A']++;
            while (isContains(sCounts, tCounts)) {
                if (minLen == -1 || (r - l + 1) < minLen) {
                    minLen = (r - l + 1);
                    startIndex = l;
                }
                sCounts[s.charAt(l) - 'A']--;
                l++;
            }
        }
        return (minLen == -1) ? "" : s.substring(startIndex, startIndex + minLen);
    }

    public boolean isContains(int[] sCounts, int[] tCounts) {
        for (int i = 0; i < sCounts.length; i++) {
            if (tCounts[i] > sCounts[i]) {
                return false;
            }
        }
        return true;
    }
}
