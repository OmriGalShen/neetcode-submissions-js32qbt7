class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<ListNode> nodeList = Arrays.asList(lists);
        while (nodeList.size() > 1) {
            List<ListNode> newList = new ArrayList<>();
            for (int i = 0; i < nodeList.size(); i += 2) {
                ListNode n;
                if (i == nodeList.size() - 1) {
                    n = nodeList.get(i);
                } else {
                    n = merge(nodeList.get(i), nodeList.get(i + 1));
                }
                newList.add(n);
            }
            nodeList = newList;
        }
        return nodeList.get(0);
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
