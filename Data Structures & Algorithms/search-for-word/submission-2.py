class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        n, m = len(board), len(board[0])

        def rec(r, c, i):
            if i == len(word):
                return True
            if (r >= n or c >= m or r < 0 or c <0):
                return False
            if board[r][c] != word[i]:
                return False
            i += 1
            t = board[r][c]
            board[r][c] = '#'
            res = (
                rec(r+1, c, i)
                or 
                rec(r, c+1, i)
                or 
                rec(r-1, c, i)
                or
                rec(r, c-1, i)
            )
            board[r][c] = t
            return res

        for r in range(n):
            for c in range(m):
                if rec(r, c, 0):
                    return True
        return False
        