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
    public int lenOf(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int n = lenOf(head);
        k = k % n;
        if (k == 0) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i <= k + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode a = slow.next;
        slow.next = null;
        ListNode tail = a;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        return a;
    }
}