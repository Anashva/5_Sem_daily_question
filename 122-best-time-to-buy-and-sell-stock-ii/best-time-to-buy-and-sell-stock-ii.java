class Solution {
    public int maxProfit(int[] nums) {
        // return profit(nums,1,0);
        int[][] dp=new int[nums.length][2];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return TD(nums,1,0,dp);
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
        else{
            sell=Math.max(arr[idx]+profit(arr,1,idx+1),profit(arr,0,idx+1));
        }
        return Math.max(sell,spend);
    }
    public int TD(int[] arr,int buy,int idx,int[][] dp){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx][buy]!=-1){
            return dp[idx][buy];
        }
        int spend=0;
        int sell=0;
        if(buy==1){
            spend=Math.max(-arr[idx]+TD(arr,0,idx+1,dp),TD(arr,1,idx+1,dp));
        }
        else{
            sell=Math.max(arr[idx]+TD(arr,1,idx+1,dp),TD(arr,0,idx+1,dp));
        }
        return dp[idx][buy]=Math.max(sell,spend);
    }

}