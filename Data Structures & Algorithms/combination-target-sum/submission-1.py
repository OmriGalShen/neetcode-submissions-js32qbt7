class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()

        def rec(i, l, s):
            if s == target:
                return [l]
            if i >= len(nums) or s > target or s + nums[i] > target:
                return []
            n = nums[i]
            return rec(i, l + [n], s+ n) + rec(i+1, l, s) 
        return rec(0, [], 0)