class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        visited = set()
        N,M = len(grid), len(grid[0])

        def bfs(row, col):
            q = deque()
            q.append((row,col))
            visited.add((row,col))
            while q:
                row, col = q.popleft()
                for dr, dc in [[1,0],[0,1],[-1,0],[0,-1]]:
                    r, c = row + dr, col + dc
                    if (r < 0 or r >= N or c < 0 or c >= M or grid[r][c] == '0' or (r,c) in visited):
                        continue
                    visited.add((r,c))
                    q.append((r,c))

        for row in range(N):
            for col in range(M):
                if grid[row][col] == '1' and (row,col) not in visited:
                    res += 1
                    bfs(row,col)
        return res