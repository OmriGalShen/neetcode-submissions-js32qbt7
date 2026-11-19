class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix.length;
        int M = matrix[0].length;
        
        int row = 0; 
        int col = M-1;
        while(col >= 0 && row < N){
            int val = matrix[row][col];
            if(val == target){
                return true;
            }
            else if(val > target){
                col--;
            } else{
                row++;
            }
        }
        return false;
    }
}
