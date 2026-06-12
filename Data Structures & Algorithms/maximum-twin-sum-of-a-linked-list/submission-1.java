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
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ArrayDeque<ListNode> twins = new ArrayDeque<>();
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null, cur = slow;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        int max = 0;
        ListNode first = head, second = prev;
        while (second != null) {
            max = Math.max(max, first.val + second.val);
            first = first.next;
            second = second.next;
        }

        return max;
    }
}