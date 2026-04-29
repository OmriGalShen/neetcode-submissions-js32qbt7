class MedianFinder:

    def __init__(self):
        self.lowHeap = []
        self.highHeap = []

    def addNum(self, num: int) -> None:
        if not self.lowHeap or num < -self.lowHeap[0]:
            heapq.heappush(self.lowHeap, -num)
        else:
            heapq.heappush(self.highHeap, num)
        
        if len(self.lowHeap) - len(self.highHeap) > 1:
            num = - heapq.heappop(self.lowHeap)
            heapq.heappush(self.highHeap, num)
        elif len(self.highHeap) - len(self.lowHeap) > 1:
            num = - heapq.heappop(self.highHeap)
            heapq.heappush(self.lowHeap, num)

    def findMedian(self) -> float:
        if not self.highHeap:
            return -self.lowHeap[0]
        if len(self.lowHeap) > len(self.highHeap):
            return -self.lowHeap[0]
        elif len(self.highHeap) > len(self.lowHeap):
            return self.highHeap[0]
        else:
            return (-self.lowHeap[0] + self.highHeap[0]) / 2
        
        