class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A, B;
        if (nums2.length < nums1.length) {
            A = nums1;
            B = nums2;
        } else {
            A = nums2;
            B = nums1;
        }
        int total = A.length + B.length;
        int half = total / 2;
        int l = -1, r = B.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int i = half - m - 2;
            int left1 = (i >= 0) ? A[i] : Integer.MIN_VALUE;
            int right1 = (i + 1 < A.length) ? A[i + 1] : Integer.MAX_VALUE;
            int left2 = (m >= 0) ? B[m] : Integer.MIN_VALUE;
            int right2 = (m + 1 < B.length) ? B[m + 1] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if (total % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.min(right1, right2);
                }
            } else if (left1 > right2) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return 0.0;
    }
}