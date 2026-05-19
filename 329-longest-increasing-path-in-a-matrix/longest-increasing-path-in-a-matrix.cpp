class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int n=matrix.size();
        int m=matrix[0].size();
        vector<vector<int>> dp(n,vector<int>(m,-1));
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans=max(ans,path(i,j,matrix,dp,INT_MIN));
            }
        }
        return ans;
    }
    int path(int cr,int cc,vector<vector<int>>& matrix,vector<vector<int>>& dp,int val){
        if(cr<0 || cc<0 || cr>=matrix.size() || cc>=matrix[0].size() || matrix[cr][cc]<=val){
            return 0;
        }
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }
        val=matrix[cr][cc];
        int ans=0;
        int l=path(cr-1,cc,matrix,dp,val)+1;
        int r=path(cr+1,cc,matrix,dp,val)+1;
        int d=path(cr,cc+1,matrix,dp,val)+1;
        int u=path(cr,cc-1,matrix,dp,val)+1;
        ans=max(ans,max(l,max(r,max(d,u))));
        return dp[cr][cc]=ans;
    }

};