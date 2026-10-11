class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToLastSeen = new HashMap<>();
        int res = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            if (charToLastSeen.containsKey(s.charAt(r))) {
                l = Math.max(l,charToLastSeen.get(s.charAt(r))+1);
            }
            charToLastSeen.put(s.charAt(r), r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

