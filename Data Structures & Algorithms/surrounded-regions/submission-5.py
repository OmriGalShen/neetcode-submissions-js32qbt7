class Solution:
    def solve(self, board: List[List[str]]) -> None:
        N, M = len(board),len(board[0])
        q = deque()
        for r in range(N):
            if board[r][0] == 'O':
                q.append((r,0))
                board[r][0] = 'T'
            if board[r][M-1] == 'O':
                q.append((r,M-1))
                board[r][M-1] = 'T'
        for c in range(M):
            if board[0][c] == 'O':
                q.append((0,c))
                board[0][c] = 'T'
            if board[N-1][c] == 'O':
                q.append((N-1,c))
                board[N-1][c] = 'T'

        while q:
            r,c = q.popleft()
            for rd, cd in [(1,0),(-1,0),(0,1),(0,-1)]:
                nr,nc = r+rd , c+ cd
                if 0 <= nr < N and 0 <= nc < M and board[nr][nc] == 'O':
                    board[nr][nc] = 'T'
                    q.append((nr,nc))

        for r in range(N):
            for c in range(M):
                if board[r][c] == 'T':
                    board[r][c] = 'O'
                elif board[r][c] == 'O':
                    board[r][c] = 'X'
            
