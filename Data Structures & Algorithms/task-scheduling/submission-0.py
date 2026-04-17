class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        d = defaultdict(int)
        for t in tasks:
            d[t]+=1
        heap = [-freq for _, freq in d.items()]
        heapq.heapify(heap)

        res = 0
        while heap:
            l = []
            for _ in range(n+1):
                if not heap and not l:
                    break
                res += 1
                if heap:
                    freq = -heapq.heappop(heap)
                    freq -= 1
                    if freq > 0:
                        l.append(freq)
            for freq in l:
                heapq.heappush(heap, -freq)

        return res