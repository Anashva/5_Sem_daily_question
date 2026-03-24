class Solution {
    int mod=1000000007;
    public int countStableSubsequences(int[] nums) {
        int[][][] dp=new int[nums.length][3][3];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return (count(nums,0,0,0,dp)-1+mod)%mod;
    }
    public int count(int[] nums,int idx,int zero,int one,int[][][] dp){
        if(zero>2 || one>2){
            return 0;
        }
        if(idx==nums.length){
            return 1;
        }
        if(dp[idx][zero][one]!=-1){
            return dp[idx][zero][one];
        }

        int val=nums[idx]%2;
        int take=0;
        if(val==0){
            take=(take+count(nums,idx+1,zero+1,0,dp))%mod;
        }
        else{
            take=(take+count(nums,idx+1,0,one+1,dp))%mod;
        }
        int skip=count(nums,idx+1,zero,one,dp);
        return dp[idx][zero][one]=(skip+take)%mod;
    }
}