class Solution:
    def totalNQueens(self, n: int) -> int:
        cols = set()
        diag1 = set()
        diag2 = set()

        def rec(row):
            if row == n:
                return 1
            res = 0
            for col in range(n):
                d1 = row - col
                d2 = row + col
                if col in cols or d1 in diag1 or d2 in diag2:
                    continue
                cols.add(col)
                diag1.add(d1)
                diag2.add(d2)
                res += rec(row+1)
                cols.remove(col)
                diag1.remove(d1)
                diag2.remove(d2)
            return res

        return rec(0)