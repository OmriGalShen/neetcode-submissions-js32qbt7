class Solution {
    /*
    def: N - digits.length
    time: O(4^N * N)
    space: output O(4^N * N) + O(N) aux
    */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        // guard
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        Map<Character, String> digitToChars = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        backtrack(0, new StringBuilder(), digits, digitToChars, result);
        return result;
    }

    private void backtrack(int i, StringBuilder curr, String digits,
        Map<Character, String> digitToChars, List<String> result) {
        if (i == digits.length()) {
            result.add(curr.toString());
            return;
        }
        String str = digitToChars.get(digits.charAt(i));
        for (int k = 0; k < str.length(); k++) {
            curr.append(str.charAt(k));
            backtrack(i+1, curr, digits, digitToChars, result);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
