class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []

        cols = set()
        diag_left = set()
        diag_right = set()

        def rec(row, mat):
            if row == n:
                res.append(mat[:])
                return
            for col in range(n):
                d1 = row - col
                d2 = row + col
                if col in cols or d1 in diag_left or d2 in diag_right:
                    continue
                cols.add(col)
                diag_left.add(d1)
                diag_right.add(d2)
                mat.append("." * col + "Q" + "." * (n - col - 1))
                rec(row + 1, mat)
                cols.remove(col)
                diag_left.remove(d1)
                diag_right.remove(d2)
                mat.pop()

        rec(0, [])
        return res
