class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        visited = set()
        N,M = len(grid), len(grid[0])

        def bfs(row, col):
            q = deque()
            q.append((row,col))
            while q:
                row, col = q.popleft()
                if row < 0 or row >= N or col < 0 or col >= M or (row,col) in visited or grid[row][col] == '0':
                    continue
                visited.add((row,col))
                q.append((row+1,col))
                q.append((row,col+1))
                q.append((row-1,col))
                q.append((row,col-1))

        for row in range(N):
            for col in range(M):
                if grid[row][col] == '1' and (row,col) not in visited:
                    res += 1
                    bfs(row,col)

        return res