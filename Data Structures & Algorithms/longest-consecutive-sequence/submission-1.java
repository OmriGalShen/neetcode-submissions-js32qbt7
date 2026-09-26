
class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        while (!set.isEmpty()) {
            int val = set.iterator().next();
            set.remove(val);
            int currLen = 1;
            int curr = val;
            while (!set.isEmpty() && set.contains(curr - 1)) {
                set.remove(curr - 1);
                curr--;
                currLen++;
            }
            curr = val;
            while (!set.isEmpty() && set.contains(curr + 1)) {
                set.remove(curr + 1);
                curr++;
                currLen++;
            }
            res = Math.max(res, currLen);
        }

        return res;
    }
}
