/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Queue<Node> cloneQueue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        cloneQueue.offer(node);
        visited.add(node.val);
        
        Node returnNode = new Node(node.val, new ArrayList<>(node.neighbors.size()));
        Map<Integer, Node> clones = new HashMap<>();
        clones.put(returnNode.val, returnNode);
        while (!cloneQueue.isEmpty()) {
            int size = cloneQueue.size();
            for (int i = 0; i < size; i++) {
                Node cur = cloneQueue.poll();
                Node clone = clones.get(cur.val);
                if (clone == null) {
                    clone = new Node(cur.val, new ArrayList<>(cur.neighbors.size()));
                    clones.put(clone.val, clone);
                }
                for (Node neighbor : cur.neighbors) {
                    if (!visited.contains(neighbor.val)) {
                        cloneQueue.offer(neighbor);
                        visited.add(neighbor.val);
                    }
                    Node cloneNeighbor = clones.get(neighbor.val);
                    if (cloneNeighbor == null) {
                        cloneNeighbor = new Node(neighbor.val, new ArrayList<>(neighbor.neighbors.size()));
                        clones.put(cloneNeighbor.val, cloneNeighbor);
                    }
                    clone.neighbors.add(cloneNeighbor);

                }
            }
        }

        return returnNode;
    }
}