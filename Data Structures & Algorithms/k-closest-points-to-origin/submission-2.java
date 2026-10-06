class Solution {
    record Point(int x, int y) {
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> Double.compare(distance(p2), distance(p1)));
        for (int[] point : points) {
            maxHeap.offer(new Point(point[0], point[1]));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] res = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            Point point = maxHeap.poll();
            res[index] = new int[]{point.x, point.y};
            index++;
        }
        return res;
    }

    private double distance(Point point) {
        return Math.sqrt(Math.pow(Math.abs(point.x), 2) + Math.pow(Math.abs(point.y), 2));
    }
}