class Solution {
    int mod = (int) 1e9 + 7;
    public int knightDialer(int n) {
        int[][] arr={{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        int[][]dp=new int[n][10];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        int ans=0;
        for(int i=0;i<=9;i++){
            ans=(ans+count(n-1,i,arr,dp))%mod;
        }
        return ans;
    }
    public int count(int n,int digit,int[][] arr,int[][]dp){
        if(n==0){
            return 1;
        }
        if(dp[n][digit]!=-1){
            return dp[n][digit];
        }
        int ans=0;
        for(int i:arr[digit]){
            ans=(ans+count(n-1,i,arr,dp))%mod;
        }
        return dp[n][digit]=ans;
    }
}