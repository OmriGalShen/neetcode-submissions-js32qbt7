
class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int n : nums) {
            if (set.contains(n - 1)) {
                continue;
            }
            int currVal = n;
            int currLen = 1;
            while (set.contains(currVal + 1)) {
                currVal++;
                currLen++;
            }
            res = Math.max(res, currLen);
        }

        return res;
    }
}
