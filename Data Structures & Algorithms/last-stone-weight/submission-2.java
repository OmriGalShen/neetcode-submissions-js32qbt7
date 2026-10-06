class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int weight : stones) {
            maxHeap.offer(weight);
        }
        while (maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            int diff = a - b;
            if (diff > 0) {
                maxHeap.offer(diff);
            }
        }
        return (!maxHeap.isEmpty()) ? maxHeap.peek() : 0;
    }
}