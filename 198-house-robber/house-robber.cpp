class Solution {
public:
    int rob(vector<int>& nums) {
        int n=nums.size();
        if(n==1){
            return nums[0];
        }
        vector<int> dp(n);
        dp[0]=nums[0];
        dp[1]=max(nums[1],nums[0]);
        for(int i=2;i<n;i++){
            int rob=dp[i-2]+nums[i];
            int nrob=dp[i-1];
            dp[i]=max(rob,nrob);
        }

        return dp[n-1];
    }
};