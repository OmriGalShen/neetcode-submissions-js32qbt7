class Solution {
    // time: O(N*log(N))
    // space: O(N)
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            if (a > b) {
                maxHeap.offer(a - b);
            }
        }
        return (maxHeap.isEmpty()) ? 0 : maxHeap.peek();
    }
}
