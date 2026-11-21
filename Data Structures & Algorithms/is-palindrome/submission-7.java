class Solution {
    public boolean isPalindrome(String s) {
        int l=0,r=s.length()-1;
        while(l < r){
            while(l < r && !isAlphaNum(s.charAt(l))){
                l++;
            }
            while(l < r && !isAlphaNum(s.charAt(r))){
                r--;
            }
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isAlphaNum(Character c){
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c<= 'Z');
    }
}
