class Solution {
    // time: O(N*log(N))
    // space: output O(N), aux O(1)
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (i == 0) {
                result.add(curr);
                continue;
            }
            int[] prev = result.get(result.size() - 1);
            if (prev[1] < curr[0]) {
                result.add(curr);
            } else {
                result.remove(result.size() - 1);
                curr[0] = Math.min(curr[0], prev[0]);
                curr[1] = Math.max(curr[1], prev[1]);
                result.add(curr);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
