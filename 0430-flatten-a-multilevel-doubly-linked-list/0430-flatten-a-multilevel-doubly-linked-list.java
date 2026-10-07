/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr = head;
        if (head == null) {
            return head;
        }
        while (curr != null) {
            if (curr.child == null) {
                curr = curr.next;
            } else {
                Node fwd = curr.next;
                Node son = flatten(curr.child);
                curr.child = null;
                curr.next = son;
                son.prev = curr;
                Node temp = son;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = fwd;
                if (fwd != null) {
                    fwd.prev = temp;
                }
                curr = fwd;

            }
        }
        return head;
    }
}