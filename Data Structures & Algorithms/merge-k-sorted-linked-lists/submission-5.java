class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<ListNode> list = Arrays.asList(lists);

        while (list.size() > 1) {
            int size = list.size();
            List<ListNode> newList = new ArrayList<>();
            for (int i = 0; i < size; i += 2) {
                if (i + 1 == size) {
                    newList.add(list.get(i));
                } else {
                    newList.add(merge(list.get(i), list.get(i + 1)));
                }
            }
            list = newList;
        }

        return list.get(0);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return head.next;
    }
}
