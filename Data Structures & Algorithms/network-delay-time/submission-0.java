class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] time: times){
            int v = time[0] - 1;
            int u = time[1] - 1;
            int t = time[2];
            graph.get(v).add(new int[]{t, u});
        }
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, k-1});
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k-1] = 0;
        while(!minHeap.isEmpty()){
            int[] val = minHeap.poll();
            int v = val[1];
            int t = val[0];

            for(int[] neighbor: graph.get(v)){
                int neighborNode = neighbor[1];
                int neighborCost = neighbor[0];
                if(t + neighborCost < distance[neighborNode]){
                    distance[neighborNode] = t + neighborCost;
                    minHeap.offer(new int[]{ t + neighborCost , neighborNode});
                }
            }
        }
        int result = 0;
        for(int i=0;i<n;i++){
            result = Math.max(result, distance[i]);
        } 
        return (result == Integer.MAX_VALUE)? -1 : result;
    }
}
