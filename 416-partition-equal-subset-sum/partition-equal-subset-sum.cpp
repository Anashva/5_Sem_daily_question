class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int total=0;
        for(int x:nums){
            total+=x;
        }
        if(total%2!=0){
            return false;
        }
        vector<vector<int>> dp(nums.size(),vector<int>(total/2+1,-1));
        return subset(nums,0,total/2,dp);
    }
    bool subset(vector<int> &nums,int idx,int sum,vector<vector<int>> &dp){
        if(sum==0){
            return true;
        }
        if(sum<0 ||idx>=nums.size()){
            return false;
        }
        if(dp[idx][sum]!=-1){
            return dp[idx][sum];
        }
        bool f1=subset(nums,idx+1,sum-nums[idx],dp);
        bool f2=subset(nums,idx+1,sum,dp);
        return dp[idx][sum]=f1 || f2;
    }
};