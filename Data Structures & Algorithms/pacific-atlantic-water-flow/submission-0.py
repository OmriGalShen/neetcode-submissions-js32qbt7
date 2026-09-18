class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        N, M = len(heights), len(heights[0])
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        pacific_rechable = set()
        q = deque()
        for r in range(N):
            cell = (r, 0)
            q.append(cell)
            pacific_rechable.add(cell)
        for c in range(M):
            cell = (0, c)
            q.append(cell)
            pacific_rechable.add(cell)
        while q:
            r, c = q.popleft()
            for rd, cd in directions:
                nr, nc = r + rd, c + cd
                if (
                    0 <= nr < N
                    and 0 <= nc < M
                    and (nr, nc) not in pacific_rechable
                    and heights[nr][nc] >= heights[r][c]
                ):
                    pacific_rechable.add((nr, nc))
                    q.append((nr, nc))

        atlantic_rechable = set()
        q = deque()
        for r in range(N):
            cell = (r, M-1)
            q.append(cell)
            atlantic_rechable.add(cell)
        for c in range(M):
            cell = (N-1, c)
            q.append(cell)
            atlantic_rechable.add(cell)
        while q:
            r, c = q.popleft()
            for rd, cd in directions:
                nr, nc = r + rd, c + cd
                if (
                    0 <= nr < N
                    and 0 <= nc < M
                    and (nr, nc) not in atlantic_rechable
                    and heights[nr][nc] >= heights[r][c]
                ):
                    atlantic_rechable.add((nr, nc))
                    q.append((nr, nc))

        return [list(cord) for cord in pacific_rechable & atlantic_rechable]
