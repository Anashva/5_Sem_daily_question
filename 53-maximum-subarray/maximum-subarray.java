class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,max(nums,i,dp));
        }
        return max;
    }
    public int max(int[] nums,int idx,int[]dp){
        if(idx==0){
            return dp[idx]=nums[0];
        }
        if(dp[idx]!=Integer.MIN_VALUE){
            return dp[idx];
        }
        int inc=nums[idx]+max(nums,idx-1,dp);//extend previous subarray
        int exc=nums[idx];//start new subrray
        return dp[idx]=Math.max(inc,exc);
    }
}