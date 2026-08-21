class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = set()
        res = 0
        N, M = len(grid), len(grid[0])
        def dfs(row, col):
            if row < 0 or col < 0 or row >= N or col >= M or grid[row][col] == '0' or(row,col) in visited:
                return
            #visited.add((row,col))
            grid[row][col] = '0'
            dfs(row+1,col)
            dfs(row,col+1)
            dfs(row-1,col)
            dfs(row,col-1)

        for row in range(N):
            for col in range(M):
                if grid[row][col] == '1':
                    res += 1
                    dfs(row,col)
        return res            



