class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        for(int num: set){
            if(!set.contains(num-1)){
                int curr = 0;
                while(set.contains(num)){
                    num++;
                    curr++;
                }
                max = Math.max(max, curr);

            }
        }
        return max;
    }
}
