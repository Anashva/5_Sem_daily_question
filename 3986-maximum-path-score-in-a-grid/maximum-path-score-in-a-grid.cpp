class Solution {
public:
    int maxPathScore(vector<vector<int>>& grid, int k) {
        int n=grid.size();
        int m=grid[0].size();
        vector<vector<vector<int>>> dp(n,vector<vector<int>>(m,vector<int>(k+1,INT_MIN)));
        int ans=count(grid,0,0,0,k,dp);
        return ans<0 ? -1 : ans;
    }
    int count(vector<vector<int>> &grid,int cr,int cc,int c,int k,vector<vector<vector<int>>>& dp){
        if(cr>=grid.size() || cc>=grid[0].size() || c>k){
            return INT_MIN;
        }
        int val=grid[cr][cc]==0 ? 0 :1;
        if(cr==grid.size()-1 && cc==grid[0].size()-1){
            if(c+val>k){
                return INT_MIN;
            }
            return grid[cr][cc];
        }
        if(dp[cr][cc][c]!=INT_MIN){
            return dp[cr][cc][c];
        }
        int r=count(grid,cr,cc+1,c+val,k,dp);
        int d=count(grid,cr+1,cc,c+val,k,dp);
        int ans=max(d,r);
        if(ans==INT_MIN){
            dp[cr][cc][c]=INT_MIN;
        }
        return dp[cr][cc][c]=grid[cr][cc]+ans;
    }
};