class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // map between signture and sublist
        Map<String, List<String>> sigToList = new HashMap<>();

        // we want to got word by word, make it into to signture and store in map
        for (String s : strs) {
            String sig = wordToSig(s);
            sigToList.computeIfAbsent(sig, k -> new ArrayList<>()).add(s);
        }

        // return map values
        return new ArrayList<>(sigToList.values());
    }

    private String wordToSig(String s) {
        int[] array = new int[26];
        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(array[i]).append('#');
        }
        return sb.toString();
    }
}
