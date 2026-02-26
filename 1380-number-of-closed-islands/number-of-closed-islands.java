class Solution {
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int closedIsland(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==0){
               bfs(grid,i,0);
            }
            if(grid[i][grid[0].length-1]==0){
                bfs(grid,i,grid[0].length-1);
            }
        }
        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i]==0){
                bfs(grid,0,i);
            }
            if(grid[grid.length-1][i]==0){
                bfs(grid,grid.length-1,i);
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    bfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
        
    }
    public void bfs(int[][] grid,int i ,int j){
        Queue<int[]>q =new LinkedList<>();
        q.add(new int[]{i,j});
        grid[i][j]=1;
        while(!q.isEmpty()){
            int[] r=q.poll();
            int x=r[0];
            int y=r[1];
            for(int[] d:dir){
                int nx=d[0]+x;
                int ny=d[1]+y;
                if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && grid[nx][ny]==0){
                    q.add(new int[]{nx,ny});
                    grid[nx][ny]=1;
                }
            }
        }
    }
}