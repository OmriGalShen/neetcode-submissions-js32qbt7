class Solution {
    // time: O(N)
    // space: O(1)
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int bestL = -1;
        int minLen = Integer.MAX_VALUE;

        int[] tArr = new int[128];
        int need = 0;
        for (char c : t.toCharArray()) {
            tArr[c]++;
            if (tArr[c] == 1) {
                need++;
            }
        }
        int l = 0;
        int[] sArr = new int[128];
        for (int r = 0; r < s.length(); r++) {
            int c = s.charAt(r);
            sArr[c]++;
            if (sArr[c] == tArr[c]) {
                need--;
            }
            while (need == 0) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    bestL = l;
                }
                char lc = s.charAt(l);
                sArr[lc]--;
                l++;
                if (sArr[lc] < tArr[lc]) {
                    need++;
                }
            }
        }
        if (bestL == -1) {
            return "";
        } else {
            return s.substring(bestL, bestL + minLen);
        }
    }
}
