class Solution {
    int mod=1000000007;
    public int countPaths(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(dp[i][j]==-1){
                    path(grid,i,j,dp,-1);
                }
            }
        }
        long ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans=(ans+dp[i][j])%mod;
            }
        }
        return (int)ans;
    }
    public int path(int[][] grid,int cr,int cc,int[][] dp,int ele){
        if(cr<0 || cr>=grid.length || cc<0 || cc>=grid[0].length || grid[cr][cc]<=ele){
            return 0;
        }
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }
        int u=path(grid,cr-1,cc,dp,grid[cr][cc])%mod;
        int d=path(grid,cr+1,cc,dp,grid[cr][cc])%mod;
        int r=path(grid,cr,cc+1,dp,grid[cr][cc])%mod;
        int l=path(grid,cr,cc-1,dp,grid[cr][cc])%mod;
        return dp[cr][cc]=(u+d+r+l+1)%mod;
    }
}