class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        for(int [] a:dp){
            Arrays.fill(a,-1000000);
        }
        int ans=Integer.MAX_VALUE;
        for (int i=0;i<m;i++){
            ans=Math.min(ans,TD(matrix,dp,0,i,n,m));
        }
        return ans;
    }

    public static int TD(int[][] matrix,int[][] dp,int i,int j,int n,int m){
        if(j<0 || j>=m){
            return Integer.MAX_VALUE;
        }
        if(i==n-1){
            return matrix[i][j];
        }
        if(dp[i][j]!=-1000000){
            return dp[i][j];
        }
        int dl=TD(matrix,dp,i+1,j-1,n,m);
        int dr=TD(matrix,dp,i+1,j+1,n,m);
        int dwon=TD(matrix,dp,i+1,j,n,m);
        return dp[i][j]= Math.min(dl,Math.min(dr,dwon))+matrix[i][j];
    }
}