class Solution {
    public int getMaximumGold(int[][] grid) {
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans=Math.max(ans,path(grid,i,j));
            }
        }
        return ans;
    }
    public int path(int[][] grid,int cr,int cc){
        if(cr<0 || cr>=grid.length || cc<0 || cc>=grid[0].length || grid[cr][cc]==0){
            return 0;
        }
        int val=grid[cr][cc];
        int ans=0;
        grid[cr][cc]=0;
        int l=path(grid,cr,cc-1);
        int r=path(grid,cr,cc+1);
        int u=path(grid,cr-1,cc);
        int d=path(grid,cr+1,cc);
        ans=Math.max(l,Math.max(r,Math.max(u,d)));
        grid[cr][cc]=val;
        return ans+val;
    }
}