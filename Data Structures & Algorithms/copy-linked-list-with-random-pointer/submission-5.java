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
        Node dummy = new Node(0);
        Node currCopy = dummy;
        Node curr = head;
        while (curr != null) {
            Node newCopy = new Node(curr.val);
            newCopy.random = curr;
            currCopy.next = newCopy;
            Node currNext = curr.next;
            curr.next = newCopy;
            curr = currNext;
            currCopy = currCopy.next;
        }
        curr = dummy.next;
        while (curr != null) {
            if(curr.random.random != null){
                curr.random = curr.random.random.next;
            }else{
                curr.random = null;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
