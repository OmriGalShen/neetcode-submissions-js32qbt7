class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_to_set = [set() for _ in range(len(nums)+1)]
        num_to_freq = {}
        for n in nums:
            if n in num_to_freq:
                freq = num_to_freq[n]
                freq_to_set[freq].remove(n)
                freq += 1
            else:
                freq = 1
            freq_to_set[freq].add(n)
            num_to_freq[n] = freq
        res = []
        for freq_set in freq_to_set[::-1]:
            for n in freq_set:
                res.append(n)
                if len(res) == k:
                    return res
