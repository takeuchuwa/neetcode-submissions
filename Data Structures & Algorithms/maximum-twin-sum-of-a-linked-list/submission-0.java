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
        while (slow != null) {
            twins.push(slow);
            slow = slow.next;
        }
        int max = 0;
        while (!twins.isEmpty()) {
            max = Math.max(max, head.val + twins.pop().val);
            head = head.next;
        }

        return max;
    }
}