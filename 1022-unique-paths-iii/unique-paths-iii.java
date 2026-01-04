class Solution {
    int ans=0;
    int zero=1;
    public int uniquePathsIII(int[][] grid) {
        int si=0;
        int ei=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    si=i;
                    ei=j;
                }
                else if(grid[i][j]==0){
                   zero++;
                }
            }
        }
        path(grid,si,ei,0);
        return ans;
    }
    public void path(int[][] grid,int cr,int cc,int count){
        if(cr>=grid.length || cr<0 || cc>=grid[0].length || cc<0 || grid[cr][cc]==-1){
            return;
        }
        if(grid[cr][cc]==2){
            if(count==zero){
                ans++;
            }
            return;
        }
        grid[cr][cc]=-1;
        path(grid,cr+1,cc,count+1);
        path(grid,cr,cc+1,count+1);
        path(grid,cr-1,cc,count+1);
        path(grid,cr,cc-1,count+1);
        grid[cr][cc]=0;

    }
}