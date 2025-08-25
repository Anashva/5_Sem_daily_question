class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[] arr=new int[m*n];
        int i=0;
        int j=0;
        for(int k=0;k<arr.length;k++){
            arr[k]=mat[i][j];
            if((i+j)%2==0){
                if(j==n-1){
                    i++;
                }
                else if(i==0){
                    j++;
                }
                else{
                    i--;
                    j++;
                }
            }
            else{
                if(i==m-1){
                    j++;
                }
                else if(j==0){
                    i++;
                }
                else{
                    j--;
                    i++;
                }
            }
        }
        return arr;
    }
}