class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []

        def rec(l, open_c, close_c):
            if len(l) == 2 * n:
                res.append("".join(l))
                return

            if close_c < open_c:
                l.append(")")
                rec(l, open_c, close_c + 1)
                l.pop()

            if open_c < n:
                l.append("(")
                rec(l, open_c + 1, close_c)
                l.pop()

        rec([], 0, 0)
        return res
