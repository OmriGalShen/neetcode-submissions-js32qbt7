class Solution {
    // time: O(N)
    // space: O(N)
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<List<Integer>> freqToNums = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            freqToNums.add(new ArrayList<>());
        }
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int num : nums) {
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }
        for (int num : numToFreq.keySet()) {
            int freq = numToFreq.get(num);
            freqToNums.get(freq).add(num);
        }
        int[] result = new int[k];
        int index = 0;
        for (int freq = n; freq >= 0; freq--) {
            for (int num : freqToNums.get(freq)) {
                result[index] = num;
                index++;
                if (index == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
