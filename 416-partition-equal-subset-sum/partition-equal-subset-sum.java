class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i:nums){
            total+=i;
        }
        if(total%2!=0){
            return false;
        }
        Boolean[][] dp=new Boolean[total/2+1][nums.length];
        return part(nums,total/2,0,dp);
    }
    public boolean part(int[] nums,int sum,int idx,Boolean[][]dp){
        if(sum==0){
            return true;
        }
        if(sum<0 || idx>=nums.length){
            return false;
        }
        if(dp[sum][idx]!=null){
            return dp[sum][idx];
        }
        boolean s1=part(nums,sum-nums[idx],idx+1,dp);
        boolean s2=part(nums,sum,idx+1,dp);
        return dp[sum][idx] = s1 || s2;
    }
}