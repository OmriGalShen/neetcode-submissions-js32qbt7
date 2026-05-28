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
            
            for j in range(i, len(candidates)):
                if j > i and candidates[j] == candidates[j-1]:
                    continue
                n = candidates[j]
                if n + s > target:
                    break
                l.append(n)
                rec(j+1, l, s +n)
                l.pop()

        rec(0, [], 0)
        return res