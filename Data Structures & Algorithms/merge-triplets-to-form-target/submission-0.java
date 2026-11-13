class Solution {
    /*
    def: N - triplets.length
    time: at least O(N), 
    space: 
    let's try iterate over triplets one by one
    if invaliad skip (invlaid if at least one element is bigger then targer)
    max1 max2 max3
    */
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // guard
        if(triplets == null || triplets.length == 0){
             return false;
        }
        int xMax = 0;
        int yMax = 0;
        int zMax = 0;
        for(int[] triplet: triplets){
            int x = triplet[0];
            int y = triplet[1];
            int z = triplet[2];
            if(x > target[0] || y > target[1] || z > target[2]){
                //invalid
                continue;
            }
            xMax = Math.max(xMax, x);
            yMax = Math.max(yMax, y);
            zMax = Math.max(zMax, z);
        }

        return xMax == target[0] && yMax == target[1] && zMax == target[2];
        
    }
}
