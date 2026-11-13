class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int l = 0;
        int maxLen = 1;
        int prevSign = 0;
        for (int r = 1; r < arr.length; r++) {
            int currSign = Integer.compare(arr[r], arr[r - 1]);
            if (currSign == 0) {
                l = r;
            } else if (prevSign == 0 || currSign != prevSign) {
                maxLen = Math.max(maxLen, r - l + 1);
            } else {
                l = r - 1;
                maxLen = Math.max(maxLen, 2);
            }
            prevSign = currSign;
        }
        return maxLen;
    }
}