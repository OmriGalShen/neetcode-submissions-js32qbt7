class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        res = 0
        visited = set()
        N, M = len(grid), len(grid[0])

        def dfs(row, col):
            if (
                row < 0
                or row >= N
                or col < 0
                or col >= M
                or grid[row][col] == 0
                or (row, col) in visited
            ):
                return 0
            visited.add((row, col))
            return 1 + dfs(row + 1, col) + dfs(row, col + 1) + dfs(row - 1, col) + dfs(row, col - 1)

        for row in range(N):
            for col in range(M):
                if grid[row][col] == 1 and (row, col) not in visited:
                    res = max(res, dfs(row, col))
        return res
