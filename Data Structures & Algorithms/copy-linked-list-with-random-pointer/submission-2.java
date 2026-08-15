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
        Map<Node, List<Node>> future = new HashMap<>();
        Map<Node, Node> nodes = new HashMap<>();
        while (curr != null) {
            newCurr.next = new Node(curr.val);
            newCurr = newCurr.next;
            
            if (nodes.containsKey(curr.random)) {
                newCurr.random = nodes.get(curr.random);
            } else {
                future.computeIfAbsent(curr.random, k -> new ArrayList<>()).add(newCurr);
            }
            if (future.containsKey(curr)) {
                List<Node> randomCurr = future.get(curr);
                for (Node tmp: randomCurr) {
                    tmp.random = newCurr;
                }
                
            }
            nodes.put(curr, newCurr);
            curr = curr.next;
        }
        curr = head;
        newCurr = dummyNode.next;
        while (curr != null) {
            
            curr = curr.next;
            newCurr = newCurr.next;
        }
        
        

        return dummyNode.next;
    }
}
