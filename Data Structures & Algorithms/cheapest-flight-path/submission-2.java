class Solution {
    /*
    time: O(K*E) 
    space: O(V)
    */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        int maxValue = Integer.MAX_VALUE / 2;
        Arrays.fill(dist, maxValue);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] prev = dist.clone();
            boolean updated = false;

            for (int[] flight : flights) {
                int a = flight[0];
                int b = flight[1];
                int price = flight[2];
                if (prev[a] != maxValue && prev[a] + price < dist[b]) {
                    dist[b] = prev[a] + price;
                    updated = true;
                }
            }
            if (!updated) {
                break;
            }
        }
        return (dist[dst] == maxValue) ? -1 : dist[dst];
    }
}
