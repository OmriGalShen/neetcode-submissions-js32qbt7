class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyToGroup = new HashMap<>();
        for(String s: strs){
            int[] a = new int[26];
            for(char c: s.toCharArray()){
                a[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append(a[i]).append('#');
            }
            String key = sb.toString();
            keyToGroup.computeIfAbsent(key, k-> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(keyToGroup.values());
    }
}
