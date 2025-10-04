class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return robb(nums,0,dp);
    }
    public int robb(int[] nums,int idx,int [] dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }

        int rob=0;
        int nrob=0;
        rob=nums[idx]+robb(nums,idx+2,dp);
        nrob=robb(nums,idx+1,dp);
        return dp[idx]=Math.max(rob,nrob);
    }
}