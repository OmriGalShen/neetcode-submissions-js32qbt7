class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for (String s : strs) {
            List<Integer> key = wordToList(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public List<Integer> wordToList(String word) {
        List<Integer> res = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            res.add(0);
        }
        for (char c : word.toCharArray()) {
            res.set(c - 'a', res.get(c - 'a') + 1);
        }
        return res;
    }
}
