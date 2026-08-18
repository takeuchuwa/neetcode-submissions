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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        
        int index = 1;
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode beforeLeft = null;
        ListNode afterRight = null;
        while (curr != null) {
            ListNode next = curr.next;
            if (index >= left && index <= right) {
                if (index == left) {
                    leftNode = curr;
                    beforeLeft = prev;
                }
                if (index == right) {
                    rightNode = curr;
                    afterRight = next;
                }
                curr.next = prev;
                
            }
            prev = curr;
            curr = next;
            index++;
        }
        if (beforeLeft != null) {
            System.out.println(beforeLeft.val);
            beforeLeft.next = rightNode;
        }
        leftNode.next = afterRight;

        return left == 1 ? rightNode : head;
    }
}