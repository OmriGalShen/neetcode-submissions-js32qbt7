class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        for (int r = 0; r < nums.length; r++) {
            while (!deque.isEmpty() && deque.peekFirst() < r - k + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[r]) {
                deque.pollLast();
            }
            deque.offerLast(r);
            if (r >= k - 1) {
                res[i] = nums[deque.peekFirst()];
                i++;
            }

        }
        return res;
    }
}