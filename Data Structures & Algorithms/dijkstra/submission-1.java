class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            adjList.get(edge.get(0)).add(new int[] {edge.get(1), edge.get(2)});
        }

        Map<Integer, Integer> output = new HashMap<>();
        PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        min.offer(new int[] {src, 0});

        while (!min.isEmpty()) {
            int[] edge = min.poll();
            if (output.containsKey(edge[0])) continue;
            output.put(edge[0], edge[1]);
            for (int[] neighbour : adjList.get(edge[0])) {
                if (!output.containsKey(neighbour[0])) {
                    min.offer(new int[] {neighbour[0], edge[1] + neighbour[1]});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!output.containsKey(i)) {
                output.put(i, -1);
            }
        }

        return output;
    }  
}
