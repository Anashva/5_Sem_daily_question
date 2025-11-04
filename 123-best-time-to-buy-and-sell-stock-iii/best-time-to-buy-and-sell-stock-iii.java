class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp=new int[prices.length][2][3];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return profit(prices,0,1,0,dp);
    }
    public int profit(int[] arr,int idx,int turn,int two,int[][][]dp){
        if(idx>=arr.length || two==2){
            return 0;
        }
        if(dp[idx][turn][two]!=-1){
            return dp[idx][turn][two];
        }
        int buy=0;
        int sell=0;
        if(turn==1){
            buy= Math.max(-arr[idx]+profit(arr,idx+1,0,two,dp),profit(arr,idx+1,1,two,dp));
        }
        else{
            sell= Math.max(arr[idx]+profit(arr,idx+1,1,two+1,dp),profit(arr,idx+1,0,two,dp));
        }
        return dp[idx][turn][two]=Math.max(buy,sell);
    }
}