class Solution {
    public long maximumProfit(int[] prices, int k) {
        long[][][] dp=new long[prices.length][k+1][3];
        for(long[][] a:dp){
            for(long[] b:a){
                Arrays.fill(b,Long.MIN_VALUE/4);
            }
        }
        return profit(prices,0,k,0,0,dp);
    }
    public long profit(int[] arr,int idx,int k,int c,int state,long[][][]dp){
        if(idx>=arr.length || c==k){//no transaction left
            if(state==0){// still having in any position then its invalid
                return 0;
            }
            return Long.MIN_VALUE/4;
        }
        if(dp[idx][c][state]!=Long.MIN_VALUE/4){
            return dp[idx][c][state];
        }
        long take=Long.MIN_VALUE/4;
        if(state==0){//state where we can buy or sell
            take=Math.max(-arr[idx]+profit(arr,idx+1,k,c,1,dp),arr[idx]+profit(arr,idx+1,k,c,2,dp));
        }
        else if(state==1){// wating for sell already buy
            take=arr[idx]+profit(arr,idx+1,k,c+1,0,dp);
        }
        else{// waiting for buy already sell;
            take=-arr[idx]+profit(arr,idx+1,k,c+1,0,dp);
        }
        long skip=profit(arr,idx+1,k,c,state,dp);
        return dp[idx][c][state]=Math.max(skip,take);

    }
}