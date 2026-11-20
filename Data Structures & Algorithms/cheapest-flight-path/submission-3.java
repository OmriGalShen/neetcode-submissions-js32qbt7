class Solution {
    /*
    time: O(K*E)
    space: O(V)
    */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] prev = dist.clone();
            boolean updated = false;

            for (int[] flight : flights) {
                int a = flight[0];
                int b = flight[1];
                int price = flight[2];
                if (prev[a] != Integer.MAX_VALUE && prev[a] + price < dist[b]) {
                    dist[b] = prev[a] + price;
                    updated = true;
                }
            }
            if (!updated) {
                break;
            }
        }
        return (dist[dst] == Integer.MAX_VALUE) ? -1 : dist[dst];
    }
}
