class Solution {
    public int[] findBall(int[][] grid) {
        int m=grid[0].length;
        int[] ans=new int[m];
        for(int j=0;j<m;j++){
            ans[j]=path(grid,0,j);
        }
        return ans;
    }
    public int path(int[][] grid,int cr,int cc){
        if(cr==grid.length){
            return cc;
        }
        if(cc<0 || cc>=grid[0].length){
            return -1;
        }

        if(grid[cr][cc]==1 && cc+1<grid[0].length && grid[cr][cc+1]==1){
            return path(grid,cr+1,cc+1);
        }
        else if(grid[cr][cc]==-1 && cc-1>=0 && grid[cr][cc-1]==-1){
            return path(grid,cr+1,cc-1);
        }
        return -1;
    }
}