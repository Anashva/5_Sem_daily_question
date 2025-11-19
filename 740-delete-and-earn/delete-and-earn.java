class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);//making one way deletion
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return earn(nums,0,dp);
    }
    public int earn(int [] nums,int idx,int[] dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int sum=0;
        int val=nums[idx];
        int curr=idx;
        while(curr<nums.length && nums[curr]==val){
            curr++;
            sum+=val;//adding duplicates
        }
        while(curr<nums.length && nums[curr]==val+1){
            curr++;//skip nums[i]+1 element
        }
        int take=sum+earn(nums,curr,dp);
        int skip=earn(nums,idx+1,dp);
        return dp[idx]=Math.max(take,skip);
    }
}