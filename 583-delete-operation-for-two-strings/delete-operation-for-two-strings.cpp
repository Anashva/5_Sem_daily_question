class Solution {
public:
    int minDistance(string word1, string word2) {
        vector<vector<int>> dp(word1.length(),vector<int>(word2.length(),-1));
        return dis(word1,word2,0,0,dp);
    }
    int dis(string s, string t,int i,int j,vector<vector<int>> &dp){
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
            ans=dis(s,t,i+1,j+1,dp);
        }
        else{
            int l=dis(s,t,i+1,j,dp);
            int d=dis(s,t,i,j+1,dp);
            ans=min(l,d)+1;
        }
        return dp[i][j]=ans;
    }
};