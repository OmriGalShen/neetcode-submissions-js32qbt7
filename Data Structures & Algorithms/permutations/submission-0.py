class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        visited = set()

        def rec(l):
            if len(l) == len(nums):
                res.append(l[:])
                return
            for n in nums:
                if n in visited:
                    continue
                l.append(n)
                visited.add(n)
                rec(l)
                l.pop()
                visited.remove(n)

        rec([])
        return res
