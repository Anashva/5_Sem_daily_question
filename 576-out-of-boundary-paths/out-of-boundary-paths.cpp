class Solution {
public:
    int mod=pow(10,9)+7;
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        vector<vector<vector<int>>> dp(m,vector<vector<int>>(n,vector<int>(maxMove+1,-1)));
        return count(n,m,startRow,startColumn,maxMove,dp);
    }
    int count(int n,int m,int cr,int cc,int mv,vector<vector<vector<int>>> &dp){
        if(cr>=m || cr<0 || cc>=n || cc<0){
            return 1;
        }
        if(mv==0){
            return 0;
        }
        if(dp[cr][cc][mv]!=-1){
            return dp[cr][cc][mv];
        }
        long long ans=0;
        ans=(ans+count(n,m,cr+1,cc,mv-1,dp))%mod;
        ans=(ans+count(n,m,cr-1,cc,mv-1,dp))%mod;
        ans=(ans+count(n,m,cr,cc+1,mv-1,dp))%mod;
        ans=(ans+count(n,m,cr,cc-1,mv-1,dp))%mod;
        return dp[cr][cc][mv]=ans;
    }
};