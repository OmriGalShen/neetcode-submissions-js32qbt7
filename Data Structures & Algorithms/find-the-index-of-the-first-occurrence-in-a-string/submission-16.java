class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = new int[needle.length()];
        int lpsPrev = 0;
        int i = 1;
        while (i < needle.length()) {
            if (needle.charAt(lpsPrev) == needle.charAt(i)) {
                lpsPrev++;
                lps[i] = lpsPrev;
                i++;
            } else if (lpsPrev == 0) {
                lps[i] = 0;
                i++;
            } else {
                lpsPrev = lps[lpsPrev - 1];
            }
        }
        i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = lps[j - 1];
            }
            if (j == needle.length()) {
                return i - needle.length();
            }
        }
        return -1;
    }
}
