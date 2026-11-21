/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode groupPrev = dummy;
        while (true) {
            ListNode end = groupPrev;
            int i = 0;
            while (end != null && i < k) {
                end = end.next;
                i++;
            }
            if (end == null) {
                break;
            }
            ListNode groupNext = end.next;
            ListNode prev = end.next;
            ListNode curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next = end;
            groupPrev = temp;
        }
        return dummy.next;
    }
}
