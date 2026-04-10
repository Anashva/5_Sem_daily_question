class Solution {
public:
    int rob(vector<int>& nums) {
        int n=nums.size();
        if(n==1){
            return nums[0];
        }
        vector<int> dp(n,-1);
        // dp[0]=nums[0];
        // dp[1]=max(nums[1],nums[0]);
        // for(int i=2;i<n;i++){
        //     int rob=dp[i-2]+nums[i];
        //     int nrob=dp[i-1];
        //     dp[i]=max(rob,nrob);
        // }

        // return dp[n-1]
        return robber(nums,0,dp);
    }
    int robber(vector<int> &nums,int idx,vector<int> &dp){
        if(idx>=nums.size()){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int rob=nums[idx]+robber(nums,idx+2,dp);
        int nrob=robber(nums,idx+1,dp);
        return dp[idx]=max(rob,nrob);
    }
};