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
        Map<Node, List<Node>> random = new HashMap<>();
        while (curr != null) {
            newCurr.next = new Node(curr.val);
            newCurr = newCurr.next;
            random.computeIfAbsent(curr.random, k -> new ArrayList<>()).add(newCurr);
            curr = curr.next;
        }
        curr = head;
        newCurr = dummyNode.next;
        while (curr != null) {
            if (random.containsKey(curr)) {
                List<Node> randomCurr = random.get(curr);
                for (Node tmp: randomCurr) {
                    tmp.random = newCurr;
                }
                
            }
            curr = curr.next;
            newCurr = newCurr.next;
        }
        
        

        return dummyNode.next;
    }
}
