class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int res = 0;
        int curr = 0;
        while (!set.isEmpty()) {
            int val = set.iterator().next();
            set.remove(val);
            curr = 1;
            int prev = val - 1;
            while (set.contains(prev)) {
                curr++;
                set.remove(prev);
                prev--;
            }
            int next = val + 1;
            while (set.contains(next)) {
                curr++;
                set.remove(next);
                next++;
            }
            res = Math.max(res, curr);
        }
        return res;

    }
}