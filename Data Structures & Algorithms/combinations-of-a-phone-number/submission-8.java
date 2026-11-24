class Solution {
    // time: O(4^N * N)
    // space: output O(4^N * N), aux O(N)
    public List<String> letterCombinations(String digits) {
        Map<Character, String> digitToChars = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), digitToChars, result);
        return result;
    }

    private void backtrack(String digits, int i, StringBuilder sb,
        Map<Character, String> digitToChars, List<String> result) {
        if (i == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (char c : digitToChars.get(digits.charAt(i)).toCharArray()) {
            sb.append(c);
            backtrack(digits, i + 1, sb, digitToChars, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
