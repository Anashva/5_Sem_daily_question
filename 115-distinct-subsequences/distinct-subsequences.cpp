class Solution {
public:
    int numDistinct(string s, string t) {
        int n=s.length();
        int m=t.length();
        vector<vector<int>> dp(n,vector<int>(m,-1));
        return count(s,t,0,0,dp);
    }
    int count(string &s,string &t,int i,int j,vector<vector<int>> &dp){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(s[i]==t[j]){
            ans=count(s,t,i+1,j+1,dp);
        }
        ans+=count(s,t,i+1,j,dp);
        return dp[i][j]=ans;
    }
};