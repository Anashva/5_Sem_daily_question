class Solution {
    int mod=(int)1000000007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int[][] dp=new int[locations.length][fuel+1];
        for(int [] a:dp){
            Arrays.fill(a,-1);
        }
        return count(locations,start,finish,fuel,dp);
    }
    public int count(int[] arr,int si,int ei,int amount,int[][]dp){
        if(amount<0){
            return 0;
        }
        if(dp[si][amount]!=-1){
            return dp[si][amount];
        }
        int ans=si==ei ? 1:0;
        for(int idx=0;idx<arr.length;idx++){
            if(idx!=si){
                if(Math.abs(arr[idx]-arr[si])<=amount){
                    ans=(ans+count(arr,idx,ei,amount-Math.abs(arr[idx]-arr[si]),dp))%mod;
                }
            }
        }
        return dp[si][amount]=ans;
    }
}