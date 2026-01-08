class Solution {
    public int minimumCoins(int[] prices) {
        int[][] dp=new int[prices.length+1][prices.length+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return coin(0,0,prices,dp);
    }
    public int coin(int i,int j,int[] nums,int[][] dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take=nums[i]+coin(i+1,i+1,nums,dp);
        int ntake=Integer.MAX_VALUE;
        if(j>0){//j=free where we can left fruits
            ntake=coin(i+1,j-1,nums,dp);
        }
        return dp[i][j]=Math.min(take,ntake);
    }
}