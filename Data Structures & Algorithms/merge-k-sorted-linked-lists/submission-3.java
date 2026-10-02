class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int size = lists.length;
        while (size > 1) {
            int index = 0;
            for (int i = 0; i < size; i += 2) {
                if (i == size - 1) {
                    lists[index] = lists[i];
                } else {
                    lists[index] = merge(lists[i], lists[i + 1]);
                }
                index++;
            }
            size = (size + 1) / 2;
        }
        return lists[0];
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                curr.next = n1;
                n1 = n1.next;
            } else {
                curr.next = n2;
                n2 = n2.next;
            }
            curr = curr.next;
        }
        curr.next = (n1 != null) ? n1 : n2;
        return dummy.next;
    }
}
