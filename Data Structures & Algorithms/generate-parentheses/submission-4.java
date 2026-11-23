class Solution {
    // time: O(2^N * N)
    // space: output O(2^N * N), aux: O(N)
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(
        int n, int openCount, int closeCount, StringBuilder sb, List<String> result) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if (openCount < n) {
            sb.append("(");
            backtrack(n, openCount + 1, closeCount, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeCount + 1 <= openCount) {
            sb.append(")");
            backtrack(n, openCount, closeCount + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
