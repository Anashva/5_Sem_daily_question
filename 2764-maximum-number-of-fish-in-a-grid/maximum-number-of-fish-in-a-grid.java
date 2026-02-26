class Solution {
    public int findMaxFish(int[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    ans=Math.max(ans,dfs(grid,i,j));
                }
            }
        }
        return ans;
    }
    public int dfs(int[][] grid,int i,int j){
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0 || grid[i][j]==0){
            return 0;
        }
        int sum=0;
        sum=grid[i][j];
        grid[i][j]=0;
        sum+=dfs(grid,i+1,j);
        sum+=dfs(grid,i-1,j);
        sum+=dfs(grid,i,j+1);
        sum+=dfs(grid,i,j-1);
        return sum;
    }
}