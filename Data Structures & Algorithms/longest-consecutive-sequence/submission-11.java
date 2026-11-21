class Solution {
    // time: O(N)
    // space: O(N)
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int maxLen = 0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int currLen = 1;
                num++;
                while(set.contains(num)){
                    currLen++;
                    num++;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }


        return maxLen;
        
    }
}
