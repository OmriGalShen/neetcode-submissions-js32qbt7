class KthLargest {
    private final Queue<Integer> heap = new PriorityQueue<>();
    private final int k;
    // time: O(N * log(K)), N = nums.length, K = k
    // space: O(K)
    public KthLargest(int k, int[] nums) {  
        this.k = k;
        for(int num: nums){
            addToHeap(num);
        }
    }
    
    // time: O(log(K))
    // space: O(K)
    public int add(int val) {
        addToHeap(val);
        return heap.peek();    
    }

    private void addToHeap(int val){
        heap.offer(val);
        if(heap.size() > k && val >= heap.peek()){
            heap.poll();
        }
    }
}
