class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) {
            return false;
        }
        int[] counts1 = new int[26];
        for (int i = 0; i < n1; i++) {
            counts1[s1.charAt(i) - 'a']++;
        }
        int[] counts2 = new int[26];
        for (int i = 0; i < n1; i++) {
            counts2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(counts1, counts2)) {
            return true;
        }
        for (int i = n1; i < s2.length(); i++) {
            counts2[s2.charAt(i) - 'a']++;
            counts2[s2.charAt(i - n1) - 'a']--;
            if (Arrays.equals(counts1, counts2)) {
                return true;
            }
        }
        return false;

    }
}
