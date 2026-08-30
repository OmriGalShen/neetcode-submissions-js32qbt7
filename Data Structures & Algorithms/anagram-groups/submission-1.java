class Solution {
    record Alpha(int[] alpha){};
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyToBucket = new HashMap<>();
        for(String s : strs){
            int[] alpha = new int[26];
            for(char c: s.toCharArray()){
                alpha[(int) c - (int)'a'] += 1;
            }
            String key = Arrays.toString(alpha);
            List<String> bucket = keyToBucket.getOrDefault(key, new ArrayList<>());
            bucket.add(s);
            keyToBucket.put(key, bucket);
        }
        return new ArrayList<>(keyToBucket.values());
    }
}
