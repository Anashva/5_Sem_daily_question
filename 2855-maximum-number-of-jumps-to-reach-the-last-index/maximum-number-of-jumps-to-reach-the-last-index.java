class Solution {
    public int maximumJumps(int[] nums, int target) {
        // int[] dp=new int[nums.length];
        // Arrays.fill(dp,-1);
        // return jump(nums,target,0,dp);
        return BU(nums,target);
    }
    public static int jump(int[] nums,int target,int idx,int[]dp){
        if(idx==nums.length-1){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ans=-1;
        for(int i=idx+1;i<nums.length;i++){
            if(Math.abs(nums[i]-nums[idx])<=target){
                int val=jump(nums,target,i,dp);
                if(val!=-1){
                    ans=Math.max(ans,1+val);
                }
            }
        }
        return dp[idx]=ans;
    }
    public static int BU(int[] nums,int target){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(dp[i]>=0 && Math.abs(nums[i]-nums[j])<=target){
                    dp[j]=Math.max(dp[j],dp[i]+1);
                }
            }
        }
        return dp[nums.length-1];
    }

}