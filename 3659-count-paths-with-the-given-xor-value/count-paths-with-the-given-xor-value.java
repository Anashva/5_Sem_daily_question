class Solution {
    int mod=1000000007;
    public int countPathsWithXorValue(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][16];
        for(int[][] a:dp){
           for(int[] b:a){
            Arrays.fill(b,-1);
           }
        }
        return count(grid,0,0,k,dp);
    }
    public int count(int[][] grid,int cr,int cc,int k,int[][][] dp){
        if(cr>=grid.length || cc>=grid[0].length){
            return 0;
        }
        if(cr==grid.length-1 && cc==grid[0].length-1){
            if((k^grid[cr][cc])==0){
                return 1;
            }
            return 0;
        }
        if(dp[cr][cc][k]!=-1){
            return dp[cr][cc][k];
        }
        int ans1=0;
        int ans2=0;
        ans1=(ans1+count(grid,cr+1,cc,k^grid[cr][cc],dp))%mod;
        ans2=(ans2+count(grid,cr,cc+1,k^grid[cr][cc],dp))%mod;
        return dp[cr][cc][k]=(ans1+ans2)%mod;
    }
}