class Solution {
public:
    int minDistance(string word1, string word2) {
        vector<vector<int>> dp(word1.size(),vector<int>(word2.size(),-1));
        return count(word1,word2,0,0,dp);
    }
    int count(string &s,string &t,int i,int j,vector<vector<int>> &dp){
        if(i==s.length()){
            return t.length()-j;
        }
        if(j==t.length()){
            return s.length()-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(s[i]==t[j]){
            ans=count(s,t,i+1,j+1,dp);
        }
        else{
            int ins=count(s,t,i,j+1,dp);
            int d=count(s,t,i+1,j,dp);
            int r=count(s,t,i+1,j+1,dp);
            ans=min(d,min(r,ins))+1;
        }
        return dp[i][j]=ans;
    }
};