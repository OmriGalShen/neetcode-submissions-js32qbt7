class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode n : lists) {
            if(n != null) {
                minHeap.offer(n);
            }
        }
        ListNode head = new ListNode();
        ListNode curr = head;
        while (!minHeap.isEmpty()){
            ListNode n = minHeap.poll();
            curr.next = n;
            curr = curr.next;
            if(n.next != null){
                minHeap.offer(n.next);
            }
        }
        return head.next;
    }
}
