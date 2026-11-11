class Solution {
    // def: N - intervals.length 
    // time: O(N)
    // space: O(1)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        // create empty list of interval
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);

        while(i < n){
            result.add(intervals[i]);
            i++;
        }

        // transform our list to int[][] and return
        return result.toArray(new int[result.size()][2]);
    }
}
