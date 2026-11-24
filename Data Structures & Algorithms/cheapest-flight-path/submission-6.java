class Solution {
    // time: O(K*E)
    // space: O(N)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            int[] tempDist = dist.clone();
            boolean updated = false;
            for (int[] flight : flights) {
                int a = flight[0];
                int b = flight[1];
                int price = flight[2];
                if (dist[a] != Integer.MAX_VALUE && dist[a] + price < tempDist[b]) {
                    tempDist[b] = dist[a] + price;
                    updated = true;
                }
            }
            dist = tempDist;
            if (updated == false) {
                break;
            }
        }

        return (dist[dst] == Integer.MAX_VALUE) ? -1 : dist[dst];
    }
}
