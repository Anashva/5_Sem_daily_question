class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return path(dp,0,0,m,n);
    }
    public int path(int[][] dp,int cr,int cc,int m,int n){
        if(cr==m-1 && cc==n-1){
            return 1;
        }
        if(cr<0 || cr>=m || cc<0 || cc>=n){
            return 0;
        }
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }
        int r=0;
        int d=0;
        r=path(dp,cr,cc+1,m,n);
        d=path(dp,cr+1,cc,m,n);
        return dp[cr][cc]=r+d;
    }
}