class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(StringBuilder sb, int open, int close, int n) {
        if (open == close && open == n) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            backtrack(sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (open > close) {
            sb.append(")");
            backtrack(sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
