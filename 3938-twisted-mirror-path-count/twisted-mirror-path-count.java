class Solution {
    int mod=(int)1e9+7;
    public int uniquePaths(int[][] grid) {
        int[][][] dp=new int[grid.length][grid[0].length][2];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return path(grid,0,0,0,dp);
    }
    public int path(int[][] grid,int cr,int cc,int mirr,int[][][]dp){
        if(cr>=grid.length || cc>=grid[0].length ){
            return 0;
        }
        if(cr==grid.length-1 && cc==grid[0].length-1){
            return 1;
        }
        if(dp[cr][cc][mirr]!=-1){
            return dp[cr][cc][mirr];
        }
        int ans=0;
        if(grid[cr][cc]==1){
            if(mirr==1){
                ans=path(grid,cr+1,cc,0,dp);
            }
            else{
                ans=path(grid,cr,cc+1,1,dp);
            }
        }
        else{
            ans+=path(grid,cr+1,cc,0,dp);
            ans+=path(grid,cr,cc+1,1,dp);
        }
        return dp[cr][cc][mirr]=ans%mod;

    }
}