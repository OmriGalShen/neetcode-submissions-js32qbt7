class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_to_set = [[] for _ in range(len(nums)+1)]
        count = Counter(nums)

        for num, freq in count.items():
            freq_to_set[freq].append(num)

        res = []
        for freq_set in freq_to_set[::-1]:
            for n in freq_set:
                res.append(n)
                if len(res) == k:
                    return res
