class Solution {
    record Task(int count, int readyTime) {
    }

    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : counts) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        Queue<Task> coolDown = new ArrayDeque<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !coolDown.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll();
                count--;
                if (count > 0) {
                    coolDown.offer(new Task(count, time + n));
                }
            }
            if (!coolDown.isEmpty() && coolDown.peek().readyTime <= time) {
                int count = coolDown.poll().count;
                maxHeap.offer(count);
            }
        }
        return time;
    }
}
