class Solution {
    // time: O(N)
    // space: O(N)
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // time: O(N)
    // space: O(B)
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i + 1;
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            String word = str.substring(j + 1, j + 1 + len);
            result.add(word);
            i = j + len+1;
        }
        return result;
    }
}
