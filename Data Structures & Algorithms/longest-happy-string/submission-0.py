class Solution:
    def longestDiverseString(self, a: int, b: int, c: int) -> str:
        heap = []
        if a > 0:
            heap.append((-a,'a'))
        if b > 0:
            heap.append((-b,'b'))
        if c > 0:
            heap.append((-c, 'c'))
        heapq.heapify(heap)
        res = []
        while heap:
            freq, char = heapq.heappop(heap)
            if len(res) < 2 or res[-1] != char or res[-2] != char:
                freq += 1
                res.append(char)
                if freq < 0:
                    heapq.heappush(heap, (freq, char))
            elif heap:
                freq2, char2 = heapq.heappop(heap)
                heapq.heappush(heap, (freq, char))
                res.append(char2)
                freq2 +=1 
                if freq2 < 0:
                    heapq.heappush(heap, (freq2, char2))
            else:
                break

        return ''.join(res)