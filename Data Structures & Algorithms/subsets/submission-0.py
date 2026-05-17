class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        def rec(i, l):
            if i >= len(nums):
                return l
            n = nums[i]
            subsets = [[n]]
            for sub in l:
                subsets.append(sub + [n])           
            return rec(i+1, l + subsets)
            
        return rec(0, []) + [[]]