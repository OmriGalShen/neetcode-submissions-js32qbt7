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
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
