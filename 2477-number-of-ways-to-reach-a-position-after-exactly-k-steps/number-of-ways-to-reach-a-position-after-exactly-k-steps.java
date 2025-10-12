class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp=new int[4000+1][k+1];
        for(int [] a:dp){
            Arrays.fill(a,-1);
        }
        return ways(startPos,endPos,k,dp);
    }
    public int ways(int si,int ei,int k,int[][]dp){
        if(k==0 && si==ei){
            return 1;
        }
        if(k==0){
            return 0;
        }
        if(dp[si+2000][k]!=-1){
            return dp[si+2000][k];
        }
        int l=ways(si-1,ei,k-1,dp);
        int r=ways(si+1,ei,k-1,dp);
        dp[si + 2000][k] = (int)((l + r) % 1000000007);
        return dp[si + 2000][k];
    }
}