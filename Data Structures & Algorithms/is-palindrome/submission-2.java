class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !isAlpha(s.charAt(l))) {
                l++;
            }
            while (l < r && !isAlpha(s.charAt(r))) {
                r--;
            }
            if (!s.substring(l,l+1).toLowerCase().equals(s.substring(r,r+1).toLowerCase())) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
