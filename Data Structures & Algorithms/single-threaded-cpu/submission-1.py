class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        tasks = [(e, p, i) for i, (e,p) in enumerate(tasks)]
        tasks.sort(key=lambda x: x[0])
        timer = 0
        res = []
        i = 0
        heap = []
        while i < len(tasks):
            if timer < tasks[i][0]:
                timer = tasks[i][0]
            while i < len(tasks) and tasks[i][0] <= timer:
                e,p,j = tasks[i]
                heapq.heappush(heap, (p,j))
                i += 1
            (p,j) = heapq.heappop(heap)
            timer += p
            res.append(j)
        while heap:
            (p,j) = heapq.heappop(heap)
            res.append(j)
        
        return res
        
        