class Solution {
    /*
    N - digits.length
    time: O(4^N * N)
    space: output O(4^N * N), aux: O(N)
    */
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> charToLatters = Map.of('2', List.of('a', 'b', 'c'), '3',
            List.of('d', 'e', 'f'), '4', List.of('g', 'h', 'i'), '5', List.of('j', 'k', 'l'), '6',
            List.of('m', 'n', 'o'), '7', List.of('p', 'q', 'r', 's'), '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z'));
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), charToLatters, result);
        return result;
    }

    private void backtrack(String digits, int i, StringBuilder sb,
        Map<Character, List<Character>> charToLatters, List<String> result) {
        if (i == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (char c : charToLatters.get(digits.charAt(i))) {
            sb.append(c);
            backtrack(digits, i + 1, sb, charToLatters, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
