class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0){
            return false;
        }
        Boolean[][] dp=new Boolean[sum/2+1][nums.length];
        return partition(nums,0,dp,sum/2);
    }
    public boolean partition(int[] nums,int idx,Boolean[][] dp,int sum){
        if(sum==0){
            return true;
        }
        if(sum<0 || idx>=nums.length){
            return false;
        }
        if(dp[sum][idx]!=null){
            return dp[sum][idx];
        }
        boolean s1=partition(nums,idx+1,dp,sum-nums[idx]);
        boolean s2=partition(nums,idx+1,dp,sum);
        return dp[sum][idx]=s1 || s2;
    }
}