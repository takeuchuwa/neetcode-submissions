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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currL1 = l1;
        ListNode currL2 = l2;
        ListNode prevL1 = null;
        ListNode prevL2 = null;
        ListNode dummy = new ListNode();
        int remainder = 0;
        ListNode res = dummy;
        while (currL1 != null && currL2 != null) {
            int sum = currL1.val + currL2.val + remainder;
            remainder = sum / 10;
            res.next = new ListNode();
            res = res.next;
            res.val = sum % 10;
            currL1 = currL1.next;
            currL2 = currL2.next;
        }

        while (currL1 != null) {
            int sum = currL1.val + remainder;
            remainder = sum / 10;
            res.next = new ListNode();
            res = res.next;
            res.val = sum % 10;
            currL1 = currL1.next;
        }

        while (currL2 != null) {
            int sum = currL2.val + remainder;
            remainder = sum / 10;
            res.next = new ListNode();
            res = res.next;
            res.val = sum % 10;
            currL2 = currL2.next;
        }

        if (remainder != 0) {
            res.next = new ListNode();
            res.next.val = remainder;
        }



        return dummy.next;
    }
}
