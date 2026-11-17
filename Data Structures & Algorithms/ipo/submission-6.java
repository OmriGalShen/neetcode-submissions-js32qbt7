class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<int[]> projectCapital = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < capital.length; i++) {
            projectCapital.offer(new int[]{i, capital[i]});
        }
        Queue<Integer> projectProfits = new PriorityQueue<>(Collections.reverseOrder());
        for (int j = 0; j < k; j++) {
            while (!projectCapital.isEmpty() && projectCapital.peek()[1] <= w) {
                int[] project = projectCapital.poll();
                int index = project[0];
                int profit = profits[index];
                projectProfits.offer(profit);
            }
            if (projectProfits.isEmpty()) {
                break;
            }
            int profit = projectProfits.poll();
            w += profit;
        }
        return w;
    }
}