class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Set<Integer>> adjList = new ArrayList<>();
        List<Set<Integer>> isPrereq = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new HashSet<>());
            isPrereq.add(new HashSet<>());
        }
        
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite: prerequisites) {
            adjList.get(prerequisite[0]).add(prerequisite[1]);
            inDegree[prerequisite[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : adjList.get(node)) {
                isPrereq.get(neighbor).add(node);
                isPrereq.get(neighbor).addAll(isPrereq.get(node));
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(isPrereq.get(query[1]).contains(query[0]));
        }
        return res;
    }
}