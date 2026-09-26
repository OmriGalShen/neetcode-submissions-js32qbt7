class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Set<Integer>> freqToSet = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            freqToSet.add(new HashSet<>());
        }
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int n : nums) {
            if (numToFreq.containsKey(n)) {
                int freq = numToFreq.get(n);
                numToFreq.put(n, freq + 1);
                freqToSet.get(freq).remove(n);
                freqToSet.get(freq + 1).add(n);
            } else {
                numToFreq.put(n, 1);
                freqToSet.get(1).add(n);
            }
        }
        int[] res = new int[k];
        int i = 0;
        for (int freq = nums.length; freq > 0; freq--) {
            for (int n : freqToSet.get(freq)) {
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
