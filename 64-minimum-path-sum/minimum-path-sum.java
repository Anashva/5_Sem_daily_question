class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return memoization(grid,dp,0,0,n,m);
    }
    public int memoization(int[][] grid,int[][]dp,int i,int j,int n,int m){
        if(i>=n || j>=m){
            return Integer.MAX_VALUE;
        }
        if(i==n-1 && j==m-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int r=memoization(grid,dp,i,j+1,n,m);//right ki call
        int d=memoization(grid,dp,i+1,j,n,m);// down ki call
        return  dp[i][j]=grid[i][j]+Math.min(r,d);
    }
}