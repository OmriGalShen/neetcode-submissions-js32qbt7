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
        if (Arrays.equals(s1Arr, s2Arr)) {
            return true;
        }
        for (int r = s1.length(); r < s2.length(); r++) {
            s2Arr[s2.charAt(r-s1.length()) - 'a']--;
            s2Arr[s2.charAt(r) - 'a']++;
            if (Arrays.equals(s1Arr, s2Arr)) {
                return true;
            }
        }
        return false;
    }
}
