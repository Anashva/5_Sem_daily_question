class Solution {
public:
    bool stoneGame(vector<int>& piles) {
        int n=piles.size();
        vector<vector<int>> dp(n,vector<int>(n,-1));
        return solve(piles,0,n-1,dp,0)>0;
    }
    int solve(vector<int>& nums,int i,int j,vector<vector<int>> &dp,int turn){
        if(i>j){
            return 0;
        }
        if(i==j){
            return nums[i];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(turn){
            ans=max(nums[i]+solve(nums,i+1,j,dp,0),nums[j]+solve(nums,i,j-1,dp,0));
        }
        else{
            ans=max(solve(nums,i+1,j,dp,1)-nums[i],solve(nums,i,j-1,dp,1)-nums[j]);
        }
        return dp[i][j]=ans;

    }
};