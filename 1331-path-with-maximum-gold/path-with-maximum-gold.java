class Solution {
    public int getMaximumGold(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans=Math.max(ans,search(grid,i,j,grid.length,grid[0].length));
            }
        }

        return ans;
    }
    public int search(int[][] grid,int cr,int cc,int er,int ec){
        if(cr<0 || cc<0 || cr==er || cc==ec || grid[cr][cc]==0){
            return 0;
        }
        int ans=0;
        int val=grid[cr][cc];
        grid[cr][cc]=0;

        int a=search(grid,cr+1,cc,er,ec);
        int b=search(grid,cr,cc+1,er,ec);
        int c=search(grid,cr-1,cc,er,ec);
        int d=search(grid,cr,cc-1,er,ec);
        
        grid[cr][cc]=val;
        ans=Math.max(Math.max(a,b),Math.max(c,d));
        return ans+val;
    }
}