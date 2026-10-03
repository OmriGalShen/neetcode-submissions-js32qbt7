class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int num : nums) {
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> freqToBucket = new ArrayList<>(nums.length + 1);
        for (int i = 0; i < nums.length + 1; i++) {
            freqToBucket.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : numToFreq.entrySet()) {
            freqToBucket.get(entry.getValue()).add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for (int freq = freqToBucket.size() - 1; freq >= 0; freq--) {
            for (int num : freqToBucket.get(freq)) {
                res[index] = num;
                index++;
                if (index == k) {
                    return res;
                }
            }

        }
        return res;
    }
}
