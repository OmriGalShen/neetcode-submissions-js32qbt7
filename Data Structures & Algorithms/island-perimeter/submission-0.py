class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        N, M = len(grid), len(grid[0])
        res = 0
        for row in range(N):
            for col in range(M):
                if grid[row][col] == 0:
                    continue
                if row == 0 or grid[row-1][col] == 0:
                    res +=1
                if row == N-1 or grid[row+1][col] == 0:
                    res +=1
                if col == 0 or grid[row][col-1] == 0:
                    res +=1
                if col == M-1 or grid[row][col+1] == 0:
                    res +=1
        return res