class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        def rec(i, acc):
            if i >= len(nums):
                return acc
            n = nums[i]
            return rec(i+1, acc ^ n) + rec(i+1, acc)
        return rec(0, 0)
        