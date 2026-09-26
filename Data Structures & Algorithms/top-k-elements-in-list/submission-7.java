class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int n : nums) {
            numToFreq.put(n, numToFreq.getOrDefault(n, 0) + 1);
        }
        List<List<Integer>> freqToList = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; i++) {
            freqToList.add(new ArrayList<>());
        }
        for (int key : numToFreq.keySet()) {
            int freq = numToFreq.get(key);
            freqToList.get(freq).add(key);
        }
        int[] res = new int[k];
        int i = 0;
        for (int freq = nums.length; freq > 0; freq--) {
            for (int n : freqToList.get(freq)) {
                res[i] = n;
                i++;
                if (i == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
