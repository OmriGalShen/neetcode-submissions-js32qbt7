class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i < n - m + 1; i++) {
            boolean b = false;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    b = true;
                    break;
                }
            }
            if (b == false) {
                return i;
            }
        }
        return -1;
    }
}