class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []

        def backtrack(i, l):
            if len(l) == k:
                res.append(l[:])
                return

            for j in range(i, n - (k - len(l)) + 2):
                l.append(j)
                backtrack(j + 1, l)
                l.pop()

        backtrack(1, [])
        return res
