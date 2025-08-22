class Solution {
    public int minimumArea(int[][] grid) {
        int rmin=grid.length;
        int cmin=grid[0].length;
        int rmax=0;
        int cmax=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    rmin=Math.min(rmin,i);
                    cmin=Math.min(cmin,j);
                    rmax=Math.max(rmax,i);
                    cmax=Math.max(cmax,j);
                }
            }
        }
        return (rmax-rmin+1)*(cmax-cmin+1);
    }
}