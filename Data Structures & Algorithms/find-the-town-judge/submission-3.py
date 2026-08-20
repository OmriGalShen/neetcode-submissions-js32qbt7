class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 1 and not trust:
            return 1
        d = defaultdict(int)
        town = set()
        for t in trust:
            a,b = t
            d[b] += 1
            town.add(a)
        for i, v in d.items():
            if v == n-1 and i not in town:
                return i
        return -1


