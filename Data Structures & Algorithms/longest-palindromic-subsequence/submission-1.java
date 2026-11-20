class Solution {
    /*
    time: O(N^2)
    space: O(N)
    */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();

        int[] prevRow = new int[n+1];
        int[] currRow = new int[n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                   currRow[j] = 1 + prevRow[j - 1];
                } else {
                    currRow[j] = Math.max(prevRow[j], currRow[j - 1]);
                }
            }
            int[] temp = prevRow;
            prevRow = currRow;
            currRow = temp;
        }

        return prevRow[n];
    }
}