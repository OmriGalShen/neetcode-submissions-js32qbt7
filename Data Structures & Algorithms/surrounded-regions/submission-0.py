class Solution:
    def solve(self, board: List[List[str]]) -> None:
        N, M = len(board),len(board[0])

        def dfs(r, c):
            if r < 0 or r >= N or c < 0 or c >= M or board[r][c] != 'O':
                return
            board[r][c] = 'T'
            dfs(r+1,c)
            dfs(r-1,c)
            dfs(r,c+1)
            dfs(r, c-1)
        
        for r in range(N):
            if board[r][0] == 'O':
                dfs(r,0)
            if board[r][M-1] == 'O':
                dfs(r,M-1)
        for c in range(M):
            if board[0][c] == 'O':
                dfs(0,c)
            if board[N-1][c] == 'O':
                dfs(N-1,c)
        for r in range(N):
            for c in range(M):
                if board[r][c] == 'T':
                    board[r][c] = 'O'
                elif board[r][c] == 'O':
                    board[r][c] = 'X'
            
