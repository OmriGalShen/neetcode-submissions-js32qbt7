class Solution {
    List<String> res;
    Map<Character, List<Character>> digitToChar;

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        this.res = new ArrayList<>();
        this.digitToChar = Map.of(
            '2', List.of('a','b','c'),
            '3', List.of('d','e','f'),
            '4', List.of('g','h','i'),
            '5', List.of('j','k','l'),
            '6', List.of('m','n','o'),
            '7', List.of('p','q','r', 's'),
            '8', List.of('t','u','v'),
            '9', List.of('w','x','y','z')
        ); 
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits,int  i, StringBuilder curr){
        if(i == digits.length()){
            res.add(curr.toString());
            return;
        }
        for(char c: digitToChar.get(digits.charAt(i))){
            curr.append(c);
            backtrack(digits, i+1, curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
