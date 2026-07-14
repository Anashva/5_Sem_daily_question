class Solution {
public:
    int bestTeamScore(vector<int>& scores, vector<int>& ages) {
        vector<pair<int,int>> arr;
        for(int i=0;i<scores.size();i++){
            arr.push_back({ages[i],scores[i]});
        }
        sort(arr.begin(),arr.end(),[](const pair<int,int> &a,const pair<int,int> &b){
            if(a.first==b.first){
                return b.second>a.second;
            }
            return a.first<b.first;

        });
        vector<vector<long long>> dp(scores.size(),vector<long long>(scores.size()+1,-1));
        return solve(arr,0,-1,dp);
    }
    long long solve(vector<pair<int,int>> &arr,int idx,int prev,vector<vector<long long>> &dp){
        if(idx==arr.size()){
            return 0;
        }
        if(dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }
        long long take=0;
        if(prev==-1 || arr[prev].second<=arr[idx].second){
            take=arr[idx].second+solve(arr,idx+1,idx,dp);
        }
        long long skip=solve(arr,idx+1,prev,dp);
        return dp[idx][prev+1]=max(take,skip);
    }
};