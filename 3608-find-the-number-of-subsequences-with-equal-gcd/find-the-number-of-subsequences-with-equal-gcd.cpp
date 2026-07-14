class Solution {
public:
    const int mod=1e9+7;
    int subsequencePairCount(vector<int>& nums) {
        vector<vector<vector<long long>>> dp(nums.size(),vector<vector<long long>>(201,vector<long long>(201,-1)));
        return count(nums,0,0,0,dp);
    }
    long long count(vector<int> &nums,int idx,int g1,int g2,vector<vector<vector<long long>>> &dp){
        if(idx==nums.size()){
            if(g1!=0 && g2!=0 && g1==g2){
                return 1;
            }
            return 0;
        }
        if(dp[idx][g1][g2]!=-1){
            return dp[idx][g1][g2];
        }
        int take1=count(nums,idx+1,gcd(g1,nums[idx]),g2,dp);
        int take2=count(nums,idx+1,g1,gcd(g2,nums[idx]),dp);
        int skip=count(nums,idx+1,g1,g2,dp);
        long long ans = (1LL * take1 + take2 + skip) % mod;
        return dp[idx][g1][g2] = ans;
    }
};