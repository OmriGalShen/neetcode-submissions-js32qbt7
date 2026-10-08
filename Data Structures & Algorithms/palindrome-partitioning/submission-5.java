class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, s);
        return res;
    }

    private void backtrack(List<String> curr, int i, String s) {
        if (i == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrom(s, i, j)) {
                curr.add(s.substring(i, j + 1));
                backtrack(curr, j + 1, s);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrom(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
