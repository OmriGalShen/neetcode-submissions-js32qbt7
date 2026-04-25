class Solution:
    def reorganizeString(self, s: str) -> str:
        count = Counter(s)
        maxHeap = [(-f, c) for c,f in count.items()]
        heapq.heapify(maxHeap)
        res = []
        prev = None
        while maxHeap:
            f, c = heapq.heappop(maxHeap)
            res.append(c)
            if prev:
                heapq.heappush(maxHeap, prev)
            prev = (f+1, c) if f != -1 else None

        return ''.join(res) if not prev else ""
