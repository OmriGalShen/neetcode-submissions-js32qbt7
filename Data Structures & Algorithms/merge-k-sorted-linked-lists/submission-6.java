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
    // N - lists.length, K - number of total nodes
    // time: O(Log(N)*K)
    // space: O(N)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int n = lists.length;
        List<ListNode> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(lists[i]);
        }
        while (list.size() > 1) {
            List<ListNode> currList = new ArrayList<>();
            for (int i = 0; i < list.size(); i += 2) {
                ListNode node;
                if (i == list.size() - 1) {
                    node = list.get(i);
                } else {
                    ListNode l1 = list.get(i);
                    ListNode l2 = list.get(i + 1);
                    node = merge(l1, l2);
                }
                currList.add(node);
            }
            list = currList;
        }
        return list.get(0);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
