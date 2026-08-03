class Solution {
public:
    string stoneGameIII(vector<int>& stoneValue) {
        vector<vector<int>> dp(stoneValue.size(),vector<int>(2,INT_MIN));
        int ans=solve(stoneValue,0,1,dp);
        if(ans==0){
            return "Tie";
        }
        return ans>0 ? "Alice" : "Bob";
    }
    int solve(vector<int>& arr,int idx,int turn,vector<vector<int>> &dp){
        if(idx>=arr.size()){
            return 0;
        }
        if(dp[idx][turn]!=INT_MIN){
            return dp[idx][turn];
        }
        if(turn){
            int ans=INT_MIN;
            int sum=arr[idx]+solve(arr,idx+1,0,dp);
            if(idx+1<arr.size()){
                sum=max(sum,arr[idx]+arr[idx+1]+solve(arr,idx+2,0,dp));
            }
            if(idx+2<arr.size()){
                sum=max(sum,arr[idx]+arr[idx+1]+arr[idx+2]+solve(arr,idx+3,0,dp));
            }
            ans=max(ans,sum);
            return dp[idx][turn]=ans;
        }
        else{
            int ans=INT_MAX;
            int sum=-arr[idx]+solve(arr,idx+1,1,dp);
            if(idx+1<arr.size()){
                sum=min(sum,-(arr[idx]+arr[idx+1])+solve(arr,idx+2,1,dp));
            }
            if(idx+2<arr.size()){
                sum=min(sum,-(arr[idx]+arr[idx+1]+arr[idx+2])+solve(arr,idx+3,1,dp));
            }
            ans=min(ans,sum);
            return dp[idx][turn]=ans;
        }
    }
};