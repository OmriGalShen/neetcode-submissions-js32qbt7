/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        Node dummy = new Node(0);
        Node newCurr = dummy;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.random = curr.random;

            newCurr.next = clone;
            newCurr = clone;

            curr.random = clone;
            curr = curr.next;
        }
        newCurr = dummy.next;
        while (newCurr != null) {
            newCurr.random = (newCurr.random != null) ? newCurr.random.random : null;
            newCurr = newCurr.next;
        }
        return dummy.next;
    }
}
