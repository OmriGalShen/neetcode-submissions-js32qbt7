class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> nodeToNeighbors = new HashMap<>();
        for (int[] edge : edges) {
            nodeToNeighbors.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            nodeToNeighbors.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int res = 0;
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (seen[i]) {
                continue;
            }
            seen[i] = true;
            res++;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                for (int v : nodeToNeighbors.getOrDefault(queue.poll(), new ArrayList<>())) {
                    if (seen[v]) {
                        continue;
                    }
                    seen[v] = true;
                    queue.offer(v);
                }
            }
        }
        return res;
    }
}
