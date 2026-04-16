class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        heap = []
        heapq.heapify(heap)

        for point in points:
            dist = point[0] **2 + point[1] **2
            if len(heap) >= k and dist > -heap[0][0]:
                continue
            heapq.heappush(heap, (-dist, point))
            if len(heap) > k:
                heapq.heappop(heap)

        return [x[1] for x in heap]
            