class Solution {
    // time(log(N+M))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int N = nums1.length;
        int M = nums2.length;
        int total = N + M;
        int half = (total +1) / 2;
        int l = 0, r = N;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int left1 = (m - 1 >= 0) ? nums1[m - 1] : Integer.MIN_VALUE;
            int right1 = (m < N) ? nums1[m] : Integer.MAX_VALUE;
            int left2 = (half - m - 1 >= 0) ? nums2[half - m - 1] : Integer.MIN_VALUE;
            int right2 = (half - m < M)? nums2[half - m] : Integer.MAX_VALUE;
            if (left1 <= right2 && left2 <= right1) {
                if (total % 2 == 0) {
                    int left = Math.max(left1, left2);
                    int right = Math.min(right1, right2);
                    return (left + right) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
