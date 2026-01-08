class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp=new int[m][n];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return path(0,0,m,n,dp);
    }
    public int path(int cr,int cc,int m,int n,int[][]dp){
        if(cr>=m || cc>=n){
            return 0;
        }
        if(cr==m-1 && cc==n-1){
            return 1;
        }
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }
        int r=path(cr,cc+1,m,n,dp);
        int d=path(cr+1,cc,m,n,dp);
        return dp[cr][cc]=r+d;
    }
}