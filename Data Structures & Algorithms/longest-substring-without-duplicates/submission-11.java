class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int l = 0;
        Set<Character> windowSet = new HashSet<>();
        for (int r = 0; r < s.length(); r++) {
            while (windowSet.contains(s.charAt(r))) {
                windowSet.remove(s.charAt(l));
                l++;
            }
            windowSet.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
