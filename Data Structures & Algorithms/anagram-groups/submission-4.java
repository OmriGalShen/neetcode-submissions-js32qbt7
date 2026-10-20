class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyToGroup = new HashMap<>();
        for (String s : strs) {
            int[] arr = new int[26];
            for (char c : s.toCharArray()) {
                arr[c - 'a']++;
            }
            String key = Arrays.toString(arr);
            keyToGroup.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return keyToGroup.values().stream().toList();
    }
}