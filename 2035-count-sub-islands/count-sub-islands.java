class Solution {
    int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans=0;
        for(int i=0;i<grid2.length;i++){
            for(int j=0;j<grid2[0].length;j++){
                if(grid2[i][j]==1){
                    if(bfs(grid2,i,j,grid1)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public boolean bfs(int[][] grid2,int i,int j,int[][] grid1){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        boolean flag=true;
        if(grid1[i][j]==0){
            flag=false;
        }
        grid2[i][j]=0;
        while(!q.isEmpty()){
            int[] r=q.poll();
            for(int[] d:dir){
                int nx=d[0]+r[0];
                int ny=d[1]+r[1];
                if(nx>=0 && ny>=0 && nx<grid1.length && ny<grid1[0].length && grid2[nx][ny]==1){
                    if(grid1[nx][ny]==0){
                        flag=false;
                    }
                    grid2[nx][ny]=0;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return flag;
    }
}