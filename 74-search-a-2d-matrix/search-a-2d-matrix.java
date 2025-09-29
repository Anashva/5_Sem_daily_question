class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // TC->log(n*m)
        // SC->O(1)
        int m=matrix[0].length;
        int n=matrix.length;
        int l=0;
        int h=m*n-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            int r=mid/m;
            int c=mid%m;
            if(matrix[r][c]==target){
                return true;
            }
            else if(matrix[r][c]>target){
                h=mid-1;
            }
            else{

                l=mid+1;
            }
        }
        
        return false;
        
    }
}