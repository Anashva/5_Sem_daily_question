class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp=new int[prices.length][k+1][2];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return max(prices,0,1,k,0,dp);
    }
    public int max(int[] arr,int idx,int turn,int k,int c,int[][][]dp){
        if(idx>=arr.length || c==k){
            return 0;
        }
        if(dp[idx][c][turn]!=-1){
            return dp[idx][c][turn];
        }
        int buy=0;
        int sell=0;
        if(turn==1){
            buy=Math.max(-arr[idx]+max(arr,idx+1,0,k,c,dp),max(arr,idx+1,1,k,c,dp));
        }
        else{
            sell=Math.max(arr[idx]+max(arr,idx+1,1,k,c+1,dp),max(arr,idx+1,0,k,c,dp));
        }
        return dp[idx][c][turn]=Math.max(buy,sell);
    }
}