class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int half = (nums1.length + nums2.length) / 2;
        int l = -1, r = nums2.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int i = half - m - 2;
            int left1 = (i >= 0) ? nums1[i] : Integer.MIN_VALUE;
            int right1 = (i + 1 < nums1.length) ? nums1[i + 1] : Integer.MAX_VALUE;
            int left2 = (m >= 0) ? nums2[m] : Integer.MIN_VALUE;
            int right2 = (m + 1 < nums2.length) ? nums2[m + 1] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if ((nums1.length + nums2.length) % 2 == 0) {
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