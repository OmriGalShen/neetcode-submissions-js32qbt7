class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = set()
        res = 0
        N, M = len(grid), len(grid[0])
        def dfs(row, col, first):
            nonlocal res
            if row < 0 or col < 0 or row >= N or col >= M or grid[row][col] == '0' or(row,col) in visited:
                return
            visited.add((row,col))
            if first:
                res += 1
            dfs(row+1,col, False)
            dfs(row,col+1, False)
            dfs(row-1,col, False)
            dfs(row,col-1, False)
        for row in range(N):
            for col in range(M):
                dfs(row,col, True)
        return res            



