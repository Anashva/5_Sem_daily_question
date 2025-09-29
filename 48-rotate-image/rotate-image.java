class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length-1;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
            int j=0;
            int k=matrix[0].length-1;
            while(j<k){
                int t=matrix[i][j];
                matrix[i][j]=matrix[i][k];
                matrix[i][k]=t;
                j++;
                k--;
            }
        }
    }
}