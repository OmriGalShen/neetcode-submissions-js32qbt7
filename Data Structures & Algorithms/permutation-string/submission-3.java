class Solution {
    // time: O(N)
    // space: O(1)
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Arr[s1.charAt(i) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Arr[i] == s2Arr[i]) {
                matches++;
            }
        }
        if (matches == 26) {
            return true;
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            int lIndex = s2.charAt(l) - 'a';
            s2Arr[lIndex]--;
            l++;
            if (s2Arr[lIndex] == s1Arr[lIndex]) {
                matches++;
            }
            else if (s2Arr[lIndex] + 1 == s1Arr[lIndex]) {
                matches--;
            }
            int rIndex = s2.charAt(r) - 'a';
            s2Arr[rIndex]++;
            if (s2Arr[rIndex] == s1Arr[rIndex]) {
                matches++;
            }
            if (s2Arr[rIndex]-1 == s1Arr[rIndex]) {
                matches--;
            }
            if (matches == 26) {
                return true;
            }
        }
        return false;
    }
}
