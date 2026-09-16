class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        N, M = len(grid), len(grid[0])
        q = deque()
        fresh_count = 0
        for r in range(N):
            for c in range(M):
                if grid[r][c] == 2:
                    q.append((r,c))
                elif grid[r][c] == 1:
                    fresh_count += 1
        res = 0
        while q and fresh_count > 0:
            for _ in range(len(q)):
                r,c = q.popleft()

                for rd, cd in [(1,0), (-1,0), (0,1),(0,-1)]:
                    nr, nc = r + rd, c + cd
                    if 0 <= nr < N and 0 <= nc < M and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        fresh_count -= 1
                        q.append((nr,nc))
            res += 1
        return res if fresh_count == 0 else -1


        


