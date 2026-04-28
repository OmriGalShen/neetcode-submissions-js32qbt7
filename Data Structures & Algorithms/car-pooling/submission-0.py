class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        trips = [[x[2], x[1], x[0]] for x in trips]
        trips.sort(key=lambda x: x[1])
        current_cap = 0
        heap = []
        heapq.heapify(heap)
        i = 0
        while i < len(trips):
            while heap and heap[0][0] <= trips[i][1]:
                current_cap -= heap[0][2]
                heapq.heappop(heap)
            if current_cap + trips[i][2] > capacity:
                return False
            current_cap += trips[i][2]
            heapq.heappush(heap, trips[i])
            i += 1
        return True
                
