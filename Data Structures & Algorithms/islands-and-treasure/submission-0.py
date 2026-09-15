class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        N, M = len(grid), len(grid[0])
        q = deque()

        for r in range(N):
            for c in range(M):
                if grid[r][c] == 0:
                    q.append((r,c))
        
        while q:
            r,c = q.popleft()
            for dr, dc in [(1,0), (-1,0), (0,1),(0,-1)]:
                nr, nc = r +dr, c +dc
                if 0 <= nr < N and 0 <= nc < M and grid[nr][nc] == 2147483647:
                    grid[nr][nc] = 1 + grid[r][c]
                    q.append((nr, nc))