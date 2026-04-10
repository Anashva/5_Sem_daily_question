class Solution {
public:
    int rob(vector<int>& nums) {
        int n=nums.size();
        if(n==1){
            return nums[0];
        }
        vector<int> dp(n,-1);
        int ans1=robber(nums,0,n-2,dp);
        dp.assign(n,-1);
        return max(ans1,robber(nums,1,n-1,dp));
    }
    int robber(vector<int> &nums,int idx,int n,vector<int> &dp){
        if(idx>n){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int rob=nums[idx]+robber(nums,idx+2,n,dp);
        int nrob=robber(nums,idx+1,n,dp);
        return dp[idx]=max(rob,nrob);
    }
};