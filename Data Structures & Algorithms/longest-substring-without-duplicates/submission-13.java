class Solution {
    // time: O(N)
    // space: O(N)
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToLastSeen = new HashMap<>();
        int maxLen = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (charToLastSeen.containsKey(c)) {
                l = Math.max(l, charToLastSeen.get(c) + 1);
            }
            maxLen = Math.max(maxLen, r - l + 1);
            charToLastSeen.put(c, r);
        }
        return maxLen;
    }
}
