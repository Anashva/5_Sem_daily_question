class Solution {
    public int maxSatisfaction(int[] nums) {
        Arrays.sort(nums);
        int[][] dp=new int[nums.length][nums.length+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return satisf(nums,0,0,dp);
    }
    public int satisf(int[] nums,int idx,int time,int[][]dp){
        if(idx==nums.length){
            return 0;
        }
        if(dp[idx][time]!=-1){
            return dp[idx][time];
        }
        int take=nums[idx]*(time+1)+satisf(nums,idx+1,time+1,dp);
        int skip=satisf(nums,idx+1,time,dp);
        return dp[idx][time]=Math.max(take,skip);
    }
}