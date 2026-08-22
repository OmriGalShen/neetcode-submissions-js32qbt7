class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        res = 0
        N, M = len(grid), len(grid[0])

        def dfs(row, col):
            if (
                row < 0
                or row >= N
                or col < 0
                or col >= M
                or grid[row][col] == 0
            ):
                return 0
            grid[row][col] = 0
            return 1 + dfs(row + 1, col) + dfs(row, col + 1) + dfs(row - 1, col) + dfs(row, col - 1)

        for row in range(N):
            for col in range(M):
                if grid[row][col] == 1:
                    res = max(res, dfs(row, col))
        return res
