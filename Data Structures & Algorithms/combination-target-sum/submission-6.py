class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        res = []

        def rec(i, l, s):
            if s == target:
                res.append(l[:])
                return
            if i >= len(nums) or s > target:
                return
            n = nums[i]
            rec(i+1, l, s)
            l.append(n)
            rec(i, l, s+n)
            l.pop()

        rec(0, [], 0)
        return res