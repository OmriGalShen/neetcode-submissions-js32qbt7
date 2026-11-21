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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int reminder = 0;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (l1 != null || l2 != null || reminder == 1) {
            int a = (l1 == null) ? 0 : l1.val;
            int b = (l2 == null) ? 0 : l2.val;
            int sum = a + b + reminder;
            int val = sum % 10;
            reminder = sum / 10;
            curr.next = new ListNode(val);
            l1 = (l1 != null)? l1.next : null;
            l2 = (l2 != null)? l2.next : null;
            curr = curr.next;
        }

        return dummy.next;
    }
}
