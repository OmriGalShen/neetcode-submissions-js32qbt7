class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int n : nums) {
            numToFreq.put(n, numToFreq.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> minHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(numToFreq.get(a), numToFreq.get(b)));
        for (int n : numToFreq.keySet()) {
            if (minHeap.size() < k || numToFreq.get(n) > numToFreq.get(minHeap.peek())) {
                minHeap.offer(n);
            }
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }
}
