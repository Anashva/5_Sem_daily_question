class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    island(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void island(char[][] grid,int cr,int cc){
        if(cr<0 || cr>=grid.length || cc<0 || cc>=grid[0].length || grid[cr][cc]=='0'){
            return;
        }
        grid[cr][cc]='0';
        island(grid,cr+1,cc);
        island(grid,cr,cc+1);
        island(grid,cr-1,cc);
        island(grid,cr,cc-1);
    }
}