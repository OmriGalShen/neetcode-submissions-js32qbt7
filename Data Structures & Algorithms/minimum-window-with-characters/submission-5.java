class Solution {
    public String minWindow(String s, String t) {
        int[] tArray = new int[128];
        int target = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (tArray[c] == 0) {
                target++;
            }
            tArray[c]++;
        }
        int[] sArray = new int[128];
        int bestLen = Integer.MAX_VALUE;
        int bestL = -1;
        int l = 0;
        int matches = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            sArray[c]++;
            if (sArray[c] == tArray[c]) {
                matches++;
            }
            while (matches == target) {
                int len = r - l + 1;
                if (len < bestLen) {
                    bestLen = len;
                    bestL = l;
                }
                c = s.charAt(l);
                sArray[c]--;
                l++;
                if (sArray[c] < tArray[c]) {
                    matches--;
                }
            }
        }
        return (bestLen == Integer.MAX_VALUE) ? "" : s.substring(bestL, bestL + bestLen);
    }
}
