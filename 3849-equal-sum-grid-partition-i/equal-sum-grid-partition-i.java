class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long total=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                total+=grid[i][j];
            }
        }
        long horiz=total;
        long sum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                sum+=grid[i][j];
                horiz-=grid[i][j];
            }
            if(horiz==sum){
                return true;
            }
        }
        horiz=total;
        sum=0;
        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                sum+=grid[j][i];
                horiz-=grid[j][i];
            }
            if(horiz==sum){
                return true;
            }
        }
        return false;

    }
}