import random

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        target_index = len(nums)-k
        def quick_select(l, r):
            pi = random.randint(l, r)
            nums[pi], nums[r] = nums[r], nums[pi]
            p = l
            for i in range(l,r):
                if nums[i] <= nums[r]:
                    nums[p], nums[i] = nums[i], nums[p]
                    p += 1
            nums[p], nums[r] = nums[r], nums[p]
            if p == target_index:
                return nums[p]
            if p < target_index:
                return quick_select(p+1, r)
            else:
                return quick_select(l, p-1)

        return quick_select(0, len(nums)-1)