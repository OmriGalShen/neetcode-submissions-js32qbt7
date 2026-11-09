class Solution {
    private static final Character delimiter = '#';

    public String encode(List<String> strs) {
        // 2#aa3#bbb
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append(delimiter).append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            // find length
            int j = i+1;
            while(str.charAt(j) != delimiter){
                j ++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            // take substring of that length
            String word = str.substring(j+1, j+length+1);  // 2#aa3#bbb, j=1, length =2 
            strs.add(word);

            // promote index after done with current string
            i = j+length+1;
        }
        return strs;
    }
}
