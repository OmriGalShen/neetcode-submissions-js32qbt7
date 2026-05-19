class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        res = []

        def rec(i, l, s):
            nonlocal res
            if s == target:
                res.append(l[::])
                return
            if i >= len(nums) or s > target:
                return
            n = nums[i]
            l.append(n)
            rec(i, l, s+n)
            l.pop()
            rec(i+1, l, s)

        rec(0, [], 0)
        return res