class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        n = len(profits)
        project_cap = [(capital[i], i) for i in range(n)]
        project_pro = []
        heapq.heapify(project_cap)
        for _ in range(k):
            while project_cap and project_cap[0][0] <= w:
                _, i = heapq.heappop(project_cap)
                heapq.heappush(project_pro, (-profits[i], i))
            if project_pro:
                p, i = heapq.heappop(project_pro)
                p = -p
                w += p
            else:
                break
        return w