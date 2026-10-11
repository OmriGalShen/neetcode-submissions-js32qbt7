class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (i == 0) {
                res.add(interval);
                continue;
            }
            int[] lastInterval = res.get(res.size() - 1);
            if (interval[0] <= lastInterval[1]) {
                int newEnd = Math.max(interval[1], lastInterval[1]);
                res.remove(res.size() - 1);
                res.add(new int[]{lastInterval[0], newEnd});
            } else {
                res.add(interval);
            }

        }
        return res.toArray(new int[][]{});
    }
}