class Solution {
    // time: O(N*K)
    // space: O(N*K)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyToGroup = new HashMap<>();
        for (String s : strs) {
            int[] arr = new int[26];
            for (char c : s.toCharArray()) {
                arr[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int count : arr) {
                sb.append(count).append('#');
            }
            String key = sb.toString();
            keyToGroup.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(keyToGroup.values());
    }
}
