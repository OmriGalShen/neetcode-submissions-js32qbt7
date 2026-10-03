class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> charToLastSeen = new HashMap<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (charToLastSeen.containsKey(c)) {
                l = Math.max(l, charToLastSeen.get(c) + 1);
            }
            res = Math.max(res, r - l+1);
            charToLastSeen.put(c, r);
        }
        return res;
    }
}