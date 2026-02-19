class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==1){
                dfs(grid,i,0);
            }
            if(grid[i][m-1]==1){
                dfs(grid,i,m-1);
            }
        }
        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i]==1){
                dfs(grid,0,i);
            }
            if(grid[n-1][i]==1){
                dfs(grid,n-1,i);
            }
        }
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        
    }
}