class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        visited = set()

        def rec(l):
            if len(l) == len(nums):
                res.append(l[:])
                return

            for i in range(len(nums)):
                if i > 0 and nums[i] == nums[i-1] and i-1 not in visited:
                    continue
                if i in visited:
                    continue
                visited.add(i)
                l.append(nums[i])
                rec(l)
                visited.remove(i)
                l.pop()
        rec([])
        return res
