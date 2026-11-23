class Solution {
    // K - tasks.length
    // time: O(K*Log(K))
    // space: O()
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : tasks) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        Queue<int[]> readyQueue = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (char c : counts.keySet()) {
            int count = counts.get(c);
            readyQueue.offer(new int[] {c, count});
        }
        Queue<int[]> waitingQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int totalCycles = 0;
        while (!readyQueue.isEmpty() || !waitingQueue.isEmpty()) {
            if (!readyQueue.isEmpty()) {
                totalCycles++;
                int[] val = readyQueue.poll();
                char c = (char) val[0];
                int count = val[1] - 1;
                if (count > 0) {
                    waitingQueue.offer(new int[] {c, count, totalCycles + n});
                }
            } else {
                totalCycles = waitingQueue.peek()[2];
            }
            while (!waitingQueue.isEmpty() && waitingQueue.peek()[2] <= totalCycles) {
                int[] val = waitingQueue.poll();
                readyQueue.offer(new int[] {val[0], val[1]});
            }
        }
        return totalCycles;
    }
}
