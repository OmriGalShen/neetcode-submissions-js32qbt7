class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()

        def rec(i, l, s):
            if s == target:
                res.append(l[:])
                return
            if i >= len(candidates) or s > target:
                return
            n = candidates[i]
            if n +s > target:
                return
            l.append(n)
            rec(i+1, l, s+n)
            l.pop()
            while i + 1 < len(candidates) and candidates[i] == candidates[i+1]:
                i+= 1
            rec(i+1, l, s)

        rec(0, [], 0)
        return res