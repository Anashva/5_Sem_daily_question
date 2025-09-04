class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[amount+1][coins.length];
        for (int[] a:dp){
            Arrays.fill(a,-1);
        }
        return coin_change(coins,amount,0,dp);
    }
   public static int coin_change(int[] coin,int amount,int idx,int[][] dp){
        if(amount==0){
            return 1;
        }
        if(idx==coin.length){
            return 0;
        }
        if(dp[amount][idx]!=-1){
            return dp[amount][idx];
        }
        int inc=0;
        int exc=0;
        if(amount>=coin[idx]){
            inc=coin_change(coin,amount-coin[idx],idx,dp);
        }
        exc=coin_change(coin,amount,idx+1,dp);
        return dp[amount][idx]=inc+exc;
    }
}