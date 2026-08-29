class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            if(heap.size() < k){
                heap.offer(n);
            }else if (heap.peek() < n){
                heap.poll();
                heap.offer(n);
            }
        }
        return heap.peek();
    }
}
