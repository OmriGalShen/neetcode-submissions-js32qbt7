class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode groupPrev = dummy;
        while (true) {
            ListNode kNode = getKNode(groupPrev, k);
            if (kNode == null) {
                break;
            }
            ListNode nextGroup = kNode.next;
            ListNode prev = nextGroup, curr = groupPrev.next;
            while (curr != nextGroup) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next = kNode;
            groupPrev = temp;
        }
        return dummy.next;
    }

    private ListNode getKNode(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }
}