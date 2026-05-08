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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length);
    }

    public ListNode mergeKLists(ListNode[] lists, int startIndex, int endIndex) {
        if (endIndex - startIndex <= 1) {
            return lists[startIndex];
        }

        int middleIndex = (startIndex + endIndex) / 2;
        ListNode head1 = mergeKLists(lists, startIndex, middleIndex);
        ListNode head2 = mergeKLists(lists, middleIndex, endIndex);

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }

        if (head1 != null) {
            cur.next = head1;
        } else {
            cur.next = head2;
        }

        return dummyHead.next;
    }
}
