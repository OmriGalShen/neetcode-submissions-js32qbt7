class Solution {
    // time: O(2^N*N)
    // space: output O(2^N*N) + aux O(N)
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int i, List<String> curr, List<List<String>> result) {
        if (i == s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (!isPalindrom(s, i, j)) {
                continue;
            }
            curr.add(s.substring(i, j + 1));
            backtrack(s, j + 1, curr, result);
            curr.remove(curr.size() - 1);
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
