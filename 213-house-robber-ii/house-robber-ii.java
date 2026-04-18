class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp=new int[nums.length];
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        Arrays.fill(dp,-1);
        int ans=robber(nums,0,n-2);
        Arrays.fill(dp,-1);
        int ans2=robber(nums,1,n-1);
        return Math.max(ans,ans2);
    }
    public int robber(int[] nums,int si,int ei){
        if(si>ei){
            return 0;
        }
        if(dp[si]!=-1){
            return dp[si];
        }
        int rob=nums[si]+robber(nums,si+2,ei);
        int skip=robber(nums,si+1,ei);
        return dp[si]=Math.max(rob,skip);
    }
}