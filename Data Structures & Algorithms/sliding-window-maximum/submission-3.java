class Solution {
    // time: O(N)
    // space: O(K)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int l = 0, r = 0;
        while (r < n) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
                deque.pollLast();
            }
            deque.addLast(r);
            while (l > deque.peekFirst()) {
                deque.pollFirst();
            }

            if (r - l + 1 >= k) {
                result[l] = nums[deque.peekFirst()];
                l++;
            }
            r++;
        }
        return result;
    }
}
