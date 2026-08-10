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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode prevNFromEnd = new ListNode();
        prevNFromEnd.next = prevNFromEnd;
        int size = 0;

        ListNode curr = head;
        while (curr != null) {
            size++;
            if (size - n == 0) {
                prevNFromEnd = new ListNode();
                prevNFromEnd.next = head;
            } else if (size - n > 0) {
                prevNFromEnd = prevNFromEnd.next;    
            }
            curr = curr.next;
            
        }
        prevNFromEnd.next = prevNFromEnd.next.next;

        return size - n == 0 ? head.next : head;
    }
}
