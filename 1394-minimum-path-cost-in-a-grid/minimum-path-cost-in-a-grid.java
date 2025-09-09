class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int ans=Integer.MAX_VALUE;
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        for(int i=0;i<grid[0].length;i++){
            ans=Math.min(ans,path(grid,moveCost,i,0,dp));
        }
        return ans;
    }
    public int path(int[][] grid,int[][] moveCost,int cc,int cr,int[][] dp){
        if(cr==grid.length-1){
            return grid[cr][cc];
        }
        if (dp[cr][cc] != -1){
            return dp[cr][cc];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            ans=Math.min(ans,moveCost[grid[cr][cc]][i]+path(grid,moveCost,i,cr+1,dp));
        }
        return dp[cr][cc]=ans+grid[cr][cc];
    }
}