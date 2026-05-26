class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        nums.sort()

        def rec(i, l, s):
            if s == target:
                res.append(l[:])
                return
            if i >= len(nums) or s > target:
                return
            for j in range(i, len(nums)):
                if nums[j] + s > target:
                    return
                l.append(nums[j])
                rec(j, l, nums[j] + s)
                l.pop()

        rec(0,[], 0)
        return res