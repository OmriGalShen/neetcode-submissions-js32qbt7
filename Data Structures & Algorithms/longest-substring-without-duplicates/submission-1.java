class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> windowSet = new HashSet<>();
        int res = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            while (windowSet.contains(s.charAt(r))) {
                windowSet.remove(s.charAt(l));
                l++;
            }
            windowSet.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
