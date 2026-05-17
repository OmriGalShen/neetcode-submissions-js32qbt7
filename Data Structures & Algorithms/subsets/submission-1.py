class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]]

        for n in nums:
            subsets = []
            for sub in res:
                subsets.append(sub + [n])
            res += subsets

        return res