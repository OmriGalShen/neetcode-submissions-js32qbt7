class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [1]*len(nums)
        a = 1
        for i in range(len(nums)):
            res[i] *= a
            a *= nums[i]
        a = 1
        for i in range(len(nums)-1, -1, -1):
            res[i] *= a
            a *= nums[i]

        return res