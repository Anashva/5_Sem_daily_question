class Solution {
    public int maxProfit(int[] prices) {
        // return profit(prices,1,0);
        int[][] dp=new int[prices.length][2];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return TD(prices,1,0,dp);
    }
    public int profit(int[] arr,int buy,int idx){
        if(idx>=arr.length){
            return 0;
        }
        int spend=0;
        int sell=0;
        if(buy==1){
            spend=Math.max(-arr[idx]+profit(arr,0,idx+1),profit(arr,1,idx+1));
        }
        else {
            sell=Math.max(arr[idx]+profit(arr,1,idx+2),profit(arr,0,idx+1));
        }
        return Math.max(spend,sell);
    }
    public int TD(int[] arr,int buy,int idx,int[][]dp){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx][buy]!=-1){
            return dp[idx][buy];
        }
        int spend=0;
        int sell=0;
        if(buy==1){
            // agr buy krenge to 2 possibility hogi ,buy krega nhi to skip kr dega
            spend=Math.max(-arr[idx]+TD(arr,0,idx+1,dp),TD(arr,1,idx+1,dp));
        }
        else {
            // jab sell krega to next wali buy nhi kr skta ya fir skip kr dega
            sell=Math.max(arr[idx]+TD(arr,1,idx+2,dp),TD(arr,0,idx+1,dp));
        }
        return dp[idx][buy]=Math.max(spend,sell);
    }
}