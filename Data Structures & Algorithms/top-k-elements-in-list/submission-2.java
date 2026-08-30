class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int n : nums) {
            numToFreq.put(n, numToFreq.getOrDefault(n, 0) + 1);
        }
        List<List<Integer>> freqToNum = new ArrayList<>(nums.length + 1);
        for (int i = 0; i < nums.length + 1; i++) {
            freqToNum.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : numToFreq.entrySet()) {
            freqToNum.get(entry.getValue()).add(entry.getKey());
        }
        int[] res = new int[k];
        int res_i = 0;
        for (int i = nums.length; i >= 0; i--) {
            List<Integer> bucket = freqToNum.get(i);
            for (int n : bucket) {
                res[res_i] = n;
                res_i++;
                if (res_i == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
