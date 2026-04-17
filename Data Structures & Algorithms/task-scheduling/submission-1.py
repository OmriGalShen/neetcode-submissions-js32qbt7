class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        d = defaultdict(int)
        for t in tasks:
            d[t]+=1
        max_heap = [-freq for freq in d.values()]
        heapq.heapify(max_heap)

        res = 0
        while max_heap:
            l = []
            for _ in range(n+1):
                if not max_heap and not l:
                    break
                res += 1
                if max_heap:
                    freq = -heapq.heappop(max_heap)
                    freq -= 1
                    if freq > 0:
                        l.append(freq)
            for freq in l:
                heapq.heappush(max_heap, -freq)

        return res