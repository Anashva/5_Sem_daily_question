class Solution {
    public int numSquares(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        return count(n,dp);
    }
    public int count(int n,int[] dp){
        if(n==0){
            return 0;
        }
        if(n<0){
            return Integer.MAX_VALUE;
        }
        if(dp[n]!=Integer.MAX_VALUE){
            return dp[n];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            ans=Math.min(ans,1+count(n-i*i,dp));
        }
        return dp[n]=ans;
    }
}