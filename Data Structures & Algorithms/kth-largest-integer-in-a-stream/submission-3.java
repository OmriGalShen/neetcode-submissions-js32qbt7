class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        this.minHeap.offer(val);
        if (minHeap.size() > this.k) {
            this.minHeap.poll();
        }
        return this.minHeap.peek();
    }
}
