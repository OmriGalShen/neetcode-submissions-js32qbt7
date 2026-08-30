class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        N, M = len(grid), len(grid[0])
        visited = set()
        def dfs(r, c):
            if (
                r < 0 
                or r >= N
                or c < 0 
                or c >= M
                or grid[r][c] == '0'
                or (r,c) in visited
            ):
                return
            visited.add((r,c))
            dfs(r+1, c)
            dfs(r, c+1)
            dfs(r-1, c)
            dfs(r, c-1)

        res = 0
        for r in range(N):
            for c in range(M):
                if grid[r][c] == '1' and (r,c) not in visited:
                    res += 1
                    dfs(r,c)
        return res