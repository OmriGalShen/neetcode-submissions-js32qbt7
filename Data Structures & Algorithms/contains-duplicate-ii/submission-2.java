class Solution {
    /*
    time: O(N)
    space: O(K)
    */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> windowSet = new HashSet<>();
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (windowSet.contains(nums[r])) {
                return true;
            }
            windowSet.add(nums[r]);

            if (r - l + 1 > k) {
                windowSet.remove(nums[l]);
                l++;
            }
        }
        return false;
    }
}