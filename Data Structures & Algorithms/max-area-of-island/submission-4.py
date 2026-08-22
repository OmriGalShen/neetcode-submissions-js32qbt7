class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        res = 0
        N, M = len(grid), len(grid[0])

        def bfs(row,col):
            q = deque()
            q.append((row,col))
            grid[row][col] = 0
            area = 1
            while q:
                row, col = q.popleft()
                for dr, dc in [[1,0], [0,1],[-1,0],[0,-1]]:
                    r, c = row +dr, col + dc
                    if r < 0 or r >= N or c < 0 or c >= M or grid[r][c] == 0:
                        continue
                    grid[r][c] = 0
                    q.append((r,c))
                    area += 1
            return area


        for row in range(N):
            for col in range(M):
                if grid[row][col] == 1 and (row,col):
                    res = max(res, bfs(row, col))
        return res
