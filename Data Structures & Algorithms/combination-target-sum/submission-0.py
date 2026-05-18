class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        def rec(i, l, s):
            if s == target:
                return [l]
            elif s > target or i >= len(nums):
                return []
            n = nums[i]
            return rec(i, l + [n], s+n) + rec(i + 1, l, s)
            
        return rec(0, [], 0)