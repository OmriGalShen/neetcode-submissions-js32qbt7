class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        def rec(i, l):
            res.append(l[:])
            for j in range(i, len(nums)):
                n = nums[j]
                l.append(n)
                rec(j+1, l)
                l.pop()
        rec(0, [])
        return res