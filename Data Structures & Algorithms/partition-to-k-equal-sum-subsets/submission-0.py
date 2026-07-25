class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        total = sum(nums)
        nums.sort()

        if total % k != 0:
            return False
        w = total // k

        subsets = [0]*k

        def rec(i):
            if i == len(nums):
                return True
            
            for subset in range(k):
                if subsets[subset] + nums[i] <= w:
                    subsets[subset] += nums[i]
                    if rec(i+1):
                        return True
                    subsets[subset] -= nums[i]
                if subsets[subset] == 0:
                    break
            return False
        
        return rec(0)