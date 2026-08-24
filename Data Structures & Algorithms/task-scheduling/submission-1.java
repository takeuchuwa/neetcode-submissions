class Solution {

    public int leastInterval(char[] tasks, int n) {
        char[] count = new char[26];
        for (char task: tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Character> taskQueue = new PriorityQueue<>((a, b) -> Integer.compare(count[b - 'A'], count[a - 'A']));
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                taskQueue.offer((char) ('A' + i));
            }
        }
        Queue<Character> cooldownQueue = new ArrayDeque<>();
        int[] lastTimeUsed = new int[26];
        int iteration = 0;
        int processed = 0;
        while (processed != tasks.length) {
            if (!taskQueue.isEmpty()) {
                Character task = taskQueue.poll();
                if (--count[task - 'A'] > 0) {
                    cooldownQueue.offer(task);
                    lastTimeUsed[task - 'A'] = iteration;
                }
                processed++;
            }

            if (!cooldownQueue.isEmpty()) {
                int prevTaskIteration = lastTimeUsed[cooldownQueue.peek() - 'A'];
                if (iteration - prevTaskIteration >= n) {
                    taskQueue.offer(cooldownQueue.poll());
                }
            }
            
            iteration++;
        }

        return iteration;
    }
}
