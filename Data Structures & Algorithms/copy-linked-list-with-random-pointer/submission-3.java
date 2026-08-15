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
        Node dummyNode = new Node(0);

        Node curr = head;
        Node newCurr = dummyNode;
        Map<Node, Node> nodes = new HashMap<>();
        while (curr != null) {
            newCurr.next = new Node(curr.val);
            newCurr = newCurr.next;
            nodes.put(curr, newCurr);
            curr = curr.next;
        }
        curr = head;
        newCurr = dummyNode.next;
        while (curr != null) {
            newCurr.random = nodes.get(curr.random);
            curr = curr.next;
            newCurr = newCurr.next;
        }
        
        

        return dummyNode.next;
    }
}
