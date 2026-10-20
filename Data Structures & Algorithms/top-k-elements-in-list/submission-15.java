class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int num : nums) {
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> freqToNums = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            freqToNums.add(new ArrayList<>());
        }
        for (int num : numToFreq.keySet()) {
            int freq = numToFreq.get(num);
            freqToNums.get(freq).add(num);
        }
        int[] res = new int[k];
        int index = 0;
        for (int freq = nums.length; freq >= 0; freq--) {
            for (int num : freqToNums.get(freq)) {
                res[index] = num;
                index++;
                if (index == k) {
                    return res;
                }
            }
        }
        return new int[0];
    }
}
