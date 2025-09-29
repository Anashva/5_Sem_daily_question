class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // TC->
        // for(int i=0;i<matrix.length;i++){
        //     int l=0;
        //     int h=matrix[0].length-1;
        //     while(l<=h){
        //         int mid=l+(h-l)/2;
        //         if(matrix[i][mid]==target){
        //             return true;
        //         }
        //         else if(matrix[i][mid]<target){
        //             l=mid+1;
        //         }
        //         else{
        //             h=mid-1;
        //         }
        //     }
        // }
        // return false;
        int n=0;
        int m=matrix[0].length-1;
        while(n<matrix.length && m>=0){
            if(matrix[n][m]==target){
                return true;
            }
            if(matrix[n][m]>target){
                m--;
            }
            else{
                n++;
            }
        }
        return false;
    }
}