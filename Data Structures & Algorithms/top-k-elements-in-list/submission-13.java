class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int num : nums) {
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> freqToNums = new ArrayList<>(nums.length + 1);
        for (int i = 0; i < nums.length + 1; i++) {
            freqToNums.add(new ArrayList<>());
        }
        for (int num : numToFreq.keySet()) {
            freqToNums.get(numToFreq.get(num)).add(num);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length; i >= 0; i--) {
            for (int num : freqToNums.get(i)) {
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