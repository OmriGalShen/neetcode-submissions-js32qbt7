class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            if (res.isEmpty() || interval[0] > res.get(res.size() - 1)[1]) {
                res.add(interval);
            } else {
                int[] lastInterval = res.get(res.size() - 1);
                lastInterval[1] = Math.max(interval[1], lastInterval[1]);
            }
        }
        return res.toArray(new int[][]{});
    }
}