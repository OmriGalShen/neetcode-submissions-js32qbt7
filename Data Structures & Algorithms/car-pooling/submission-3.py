class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        current_cap = 0
        heap = []
        for passengers, start, end in sorted(trips, key=lambda x: x[1]):
            while heap:
                h_end, h_passengers = heap[0]
                if h_end > start:
                    break
                current_cap -= h_passengers
                heapq.heappop(heap)
            current_cap += passengers
            if current_cap > capacity:
                return False
            heapq.heappush(heap, (end, passengers))
        return True
                
