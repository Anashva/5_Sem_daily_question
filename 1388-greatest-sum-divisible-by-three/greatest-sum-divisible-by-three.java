class Solution {
    public int maxSumDivThree(int[] nums) {
        int[][] dp=new int[nums.length][3];
        for(int[] a:dp){
            Arrays.fill(a,Integer.MIN_VALUE);
        }
        return max(nums,0,0,dp);
    }
    public int max(int[] nums,int idx,int sum,int[][]dp){
        if(idx==nums.length){
            if(sum%3==0){
                return 0;
            }
            return Integer.MIN_VALUE;
        }
        if(dp[idx][sum]!=Integer.MIN_VALUE){
            return dp[idx][sum];
        }
        int ans=nums[idx]+max(nums,idx+1,(sum+nums[idx])%3,dp);
        int npick=max(nums,idx+1,sum,dp);
        return dp[idx][sum]=Math.max(ans,npick);
    }
}