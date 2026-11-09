class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // guard input
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        // [1,1,2,2,3], k = 2

        // number to frequency map, number -> frequncy
        Map<Integer, Integer> numToFreq = new HashMap();
        for (int num : nums) {
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }
        // 1 -> 2, 3 -> 1
        // frequency array, frequency -> list of numbers
        List<List<Integer>> freqToList = new ArrayList<>(nums.length + 1);
        for (int i = 0; i < nums.length + 1; i++) {
            freqToList.add(new ArrayList<>());
        }
        // freqToList = [[],[], []]
        for (int num : numToFreq.keySet()) {
            int freq = numToFreq.get(num);
            freqToList.get(freq).add(num);
        }
        
        // go backwards on frequncy array, take from lists elemenets until we get k
        int[] result = new int[k];
        int index = 0;

        for (int freq = nums.length; freq >= 0; freq--) {
            for (int num : freqToList.get(freq)) {
                result[index] = num;
                index++;
                if (index == k) {
                    return result;
                }
            }
        }
        // return k elements
        return result;
    }
}
