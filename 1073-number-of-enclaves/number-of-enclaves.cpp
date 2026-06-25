class Solution {
public:
    int numEnclaves(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                solve(grid, i, 0);
            }
            if (grid[i][m-1] == 1) {
                solve(grid, i, m - 1);
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                solve(grid,0,i);
            }
            if (grid[n-1][i] == 1) {
                solve(grid, n-1,i);
            }
        }
        int ans=0;
        for(int  i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }
    void solve(vector<vector<int>> &grid,int i,int j){
        if(i<0 || j<0 || i>=grid.size() || j>=grid[0].size() || grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        solve(grid,i+1,j);
        solve(grid,i-1,j);
        solve(grid,i,j+1);
        solve(grid,i,j-1);
    }
};