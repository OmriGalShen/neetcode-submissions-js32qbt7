class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l = 0;
        int currSum = 0;
        int res = 0;
        for (int r = 0; r < arr.length; r++) {
            currSum += arr[r];
            if (r - l + 1 == k) {
                if (currSum / k >= threshold) {
                    res++;
                }
                currSum -= arr[l];
                l++;
            }
        }
        return res;
    }
}