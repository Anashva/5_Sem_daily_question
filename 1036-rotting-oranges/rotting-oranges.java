class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        Queue<pair> q=new LinkedList<>();
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j,0));
                }
                if(grid[i][j]==1){
                    c++;
                }
            }
        }
        int max=0;
        while(!q.isEmpty()){
            pair rp=q.poll();
            int x=rp.x;
            int y=rp.y;
            int step=rp.step;
            for(int[] d:dir){
                int nx=d[0]+x;
                int ny=d[1]+y;
                max=Math.max(max,step);
                if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]==1){
                    grid[nx][ny]=2;
                    c--;
                    q.add(new pair(nx,ny,step+1));
                }
            }
        }
        return c==0?max :-1;
    }
    class pair{
        int x;
        int y;
        int step;
        public pair(int x,int y,int step){
            this.x=x;
            this.y=y;
            this.step=step;
        }
    }
}