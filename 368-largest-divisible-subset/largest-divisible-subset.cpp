class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        vector<int> ans;
        int n=nums.size();
        vector<int> dp(n);
        int maxi=0;
        vector<int> ldp(n,-1);
        int c=0;
        sort(nums.begin(),nums.end());
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    ldp[i]=j;
                }
            }
            if(c<dp[i]){
                c=dp[i];
                maxi=i;
            }
        }
        for(int i=maxi;i!=-1;i=ldp[i]){
            ans.push_back(nums[i]);
        }
        return ans;
    }
};