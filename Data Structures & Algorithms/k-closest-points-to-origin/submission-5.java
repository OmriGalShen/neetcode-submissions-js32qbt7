class Solution {
    private Random rand = new Random();
    // time: O(N) avg, worst case O(N^2)
    // space: O(1)
    public int[][] kClosest(int[][] points, int k) {
        int l = 0, r = points.length - 1;
        while (l <= r) {
            int pivot = partition(points, l, r);
            if (pivot == k - 1) {
                break;
            } else if (pivot < k - 1) {
                l = pivot + 1;
            } else {
                r = pivot - 1;
            }
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }
        return result;
    }

    private int partition(int[][] points, int l, int r) {
        if (l == r) {
            return l;
        }
        int pivot = l + rand.nextInt(r-l+1);
        swap(points, pivot, r);
        int i = l;
        for (int j = l; j < r; j++) {
            if (dist(points[j]) <= dist(points[r])) {
                swap(points, j, i);
                i++;
            }
        }
        swap(points, i, r);
        return i;
    }

    private void swap(int[][] points, int l, int r) {
        int[] temp = points[l];
        points[l] = points[r];
        points[r] = temp;
    }

    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}