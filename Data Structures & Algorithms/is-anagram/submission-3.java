class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sArray = new int[26];
        for (char c : s.toCharArray()) {
            sArray[c - 'a']++;
        }
        int[] tArray = new int[26];
        for (char c : t.toCharArray()) {
            tArray[c - 'a']++;
            if (tArray[c - 'a'] > sArray[c - 'a']) {
                return false;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }
        return true;
    }
}