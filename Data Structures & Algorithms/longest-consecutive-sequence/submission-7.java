class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int curr = 1;
            while (set.contains(num + 1)) {
                num++;
                curr ++;
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}