class Solution {
    /*
    time: O(N)
    space: O(N)
    */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int curr = 0, max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int n = num;
                curr = 0;
                while (set.contains(n)) {
                    n++;
                    curr++;
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}
