class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        def rec(i, l):
            res.append(l[:])
            for j in range(i, len(nums)):
                if j > i and nums[j] == nums[j-1]:
                    continue
                n = nums[j]
                l.append(n)
                rec(j+1, l)
                l.pop()
        rec(0, [])
        return res