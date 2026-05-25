class Graph {

    private HashMap<Integer, Set<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        if (adjList.get(src) == null) {
            adjList.put(src, new HashSet<>());
        }
        if (adjList.get(dst) == null) {
            adjList.put(dst, new HashSet<>());
        }

        adjList.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        Set<Integer> dsts = adjList.get(src);
        if (dsts == null) {
            return false;
        }
        
        return dsts.remove(dst);
    }

    public boolean hasPath(int src, int dst) {
        Queue<Integer> queue = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int el = queue.poll();
                if (el == dst) {
                    return true;
                }

                for (Integer neighbour : adjList.get(el)) {
                    if (!visited.contains(neighbour)) {
                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
        }

        return false;
    }
}
