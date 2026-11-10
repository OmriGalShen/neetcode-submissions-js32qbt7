class KthLargest {
    private final Queue<Integer> heap = new PriorityQueue<>();
    private final int k;
    // time:
    // space: 
    public KthLargest(int k, int[] nums) {  
        this.k = k;
        for(int num: nums){
            addToHeap(num);
        }
    }
    
    // time:
    // space: 
    public int add(int val) {
        addToHeap(val);
        return heap.peek();    
    }

    private void addToHeap(int val){
        heap.offer(val);
        if(heap.size() > k){
            heap.poll();
        }
    }
}
