class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (!s.substring(l, l + 1).equalsIgnoreCase(s.substring(r, r + 1))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
