class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp=new int[nums.size()][target+1];
        for(int [] a:dp){
            Arrays.fill(a,-999999);
        }
        int ans=DP(nums,target,0,dp);
        return ans<0 ? -1 :ans;
    }
    public int subs(List<Integer> nums,int k,int idx){
        if(k==0){
            return 0;
        }
        if(idx>=nums.size()){
            return -999999;
        }
        int ans=-999999;
        if(k>=nums.get(idx)){
            ans=1+subs(nums,k-nums.get(idx),idx+1);
        }
        int npick=subs(nums,k,idx+1);
        return Math.max(npick,ans);
    }
    public int DP(List<Integer> nums,int k,int idx,int[][] dp){
        if(k==0){
            return 0;
        }
        if(idx>=nums.size()){
            return -999999;
        }
        if(dp[idx][k]!=-999999){
            return dp[idx][k];
        }

        int ans=-999999;
        if(k>=nums.get(idx)){
            ans=1+DP(nums,k-nums.get(idx),idx+1,dp);
        }
        int npick=DP(nums,k,idx+1,dp);
        return dp[idx][k]=Math.max(npick,ans);
    }
    
}