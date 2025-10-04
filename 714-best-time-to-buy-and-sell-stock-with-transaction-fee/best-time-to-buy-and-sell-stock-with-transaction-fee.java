class Solution {
    public int maxProfit(int[] prices, int fee) {
        // return profit(prices,1,0,fee);
        // int[][] dp=new int[prices.length][2];
        // for(int[] a:dp){
        //     Arrays.fill(a,-1);
        // }
        // return TD(prices,1,0,fee,dp);
        return BU(prices,fee);
    }
    public int profit(int[] arr,int buy,int idx,int fee){
        if(idx>=arr.length){
            return 0;
        }
        int spend=0;
        int sell=0;
        if(buy==1){
            spend=Math.max(-arr[idx]+profit(arr,0,idx+1,fee),profit(arr,1,idx+1,fee));
        }
        else{
            sell=Math.max(arr[idx]-fee+profit(arr,1,idx+1,fee),profit(arr,0,idx+1,fee));
        }
        return Math.max(sell,spend);
    }
    public int TD(int[] arr,int buy,int idx,int fee,int[][] dp){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx][buy]!=-1){
            return dp[idx][buy];
        }
        int spend=0;
        int sell=0;
        if(buy==1){
            spend=Math.max(-arr[idx]+TD(arr,0,idx+1,fee,dp),TD(arr,1,idx+1,fee,dp));
        }
        else{
            sell=Math.max(arr[idx]-fee+TD(arr,1,idx+1,fee,dp),TD(arr,0,idx+1,fee,dp));
        }
        return Math.max(sell,spend);
    }
    public int BU(int[] arr,int fee){
        int[][] dp=new int[arr.length+1][2];
        for(int i=arr.length-1;i>=0;i--){
            for(int j=0;j<2;j++){
                if(j==1){
                    dp[i][j]=Math.max(-arr[i]+dp[i+1][0],dp[i+1][1]);
                }
                else{
                    dp[i][j]=Math.max(arr[i]-fee+dp[i+1][1],dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }

}