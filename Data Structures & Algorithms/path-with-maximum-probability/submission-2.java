class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(new Node(edges[i][1], succProb[i]));
            adjList.get(edges[i][1]).add(new Node(edges[i][0], succProb[i]));
        }

        PriorityQueue<Node> max = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        max.offer(new Node(start_node, 1));
        double[] probs = new double[n];
        while (!max.isEmpty()) {
            Node qNode = max.poll();
            if (qNode.node == end_node) {
                return qNode.prob;
            }
            for (Node neighbour : adjList.get(qNode.node)) {
                double nProb = qNode.prob * neighbour.prob;
                if (nProb > probs[neighbour.node]) {
                    probs[neighbour.node] = nProb;
                    max.offer(new Node(neighbour.node, nProb));
                }
            }
        }

        return 0.;
    }

    class Node {
        int node;
        double prob;

        Node(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}