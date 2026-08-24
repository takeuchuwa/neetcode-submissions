class Solution {

    static Task EMPTY_TASK = new Task('0', 0);
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> count = new HashMap<>();
        for (char task: tasks) {
            count.merge(task, 1, Integer::sum);
        }

        PriorityQueue<Task> taskQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
        for (Map.Entry<Character, Integer> entry: count.entrySet()) {
            taskQueue.offer(new Task(entry.getKey(), entry.getValue()));
        }
        Queue<Task> cooldownQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            cooldownQueue.offer(EMPTY_TASK);
        }
        int minIterations = 0;
        int processed = 0;
        while (processed != tasks.length) {
            if (!taskQueue.isEmpty()) {
                Task task = taskQueue.poll();
                task.count--;
                cooldownQueue.offer(task);
                processed++;
            } else {
                cooldownQueue.offer(EMPTY_TASK);
            }

            Task nextTask = cooldownQueue.poll();
            if (nextTask.count > 0) {
                taskQueue.offer(nextTask);
            }
            minIterations++;
        }

        return minIterations;
    }

    private static class Task {
        char id;
        int count;

        private Task(char id, int count) {
            this.id = id;
            this.count = count;
        }
    }
}
