class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int[][][] dp=new int[grid.length][grid[0].length][k];
        for(int[][]a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return path(grid,0,0,0,k,dp);
    }
    public int path(int[][] grid,int cr,int cc,int sum,int k,int[][][]dp){
        if(cr>=grid.length || cc>=grid[0].length){
            return 0;
        }
        if(cr==grid.length-1 && cc==grid[0].length-1 && (sum+grid[cr][cc])%k==0){
            return 1;
        }
        if(dp[cr][cc][sum]!=-1){
            return dp[cr][cc][sum];
        }
        int a=path(grid,cr+1,cc,(sum+grid[cr][cc])%k,k,dp);
        int b=path(grid,cr,cc+1,(sum+grid[cr][cc])%k,k,dp);
        return dp[cr][cc][sum]=(a+b)%1000000007;
    }
}