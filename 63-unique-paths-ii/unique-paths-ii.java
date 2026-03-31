class Solution {
    Integer[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        dp=new Integer[grid.length][grid[0].length];
        return count(grid,0,0,grid.length,grid[0].length);
    }
    public int count(int[][] grid,int i,int j,int n,int m){
        if(i>=n || j>=m || grid[i][j]==1){
            return 0;
        }
        if(i==n-1 && j==m-1){
            return 1;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int r=count(grid,i,j+1,n,m);
        int d=count(grid,i+1,j,n,m);
        return dp[i][j]=d+r;
    }
}