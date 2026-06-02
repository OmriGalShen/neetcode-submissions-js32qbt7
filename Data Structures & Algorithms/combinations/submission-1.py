class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []

        def rec(i, l):
            if len(l) == k:
                res.append(l[:])
                return
            if i > n or (n-i+1) < (k - len(l)):
                return
            l.append(i)
            rec(i+1, l)
            l.pop()
            rec(i+1, l)
        
        rec(1, [])
        return res