class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sCounts = new int[26];
        for (char c : s.toCharArray()) {
            sCounts[c - 'a']++;
        }
        int[] tCounts = new int[26];
        for (char c : t.toCharArray()) {
            tCounts[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCounts[i] != tCounts[i]) {
                return false;
            }
        }
        return true;
    }
}
