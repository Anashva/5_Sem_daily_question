class Solution {
    public int minimumObstacles(int[][] grid) {
        int[][] dir={{-1,0},{0,1},{0,-1},{1,0}};
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->(a.cost-b.cost));
        boolean[][] visit=new boolean[n][m];
        pq.add(new pair(0,0,0));
        while(!pq.isEmpty()){
            pair rp=pq.poll();
            int x=rp.x;
            int y=rp.y;
            int dis=rp.cost;
            if( visit[x][y]){
                continue;
            }
            visit[x][y]=true;
            if(x==n-1 && y==m-1){
                return dis;
            }
            for(int[] d:dir){
                int nx=x+d[0];
                int ny=y+d[1];
                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    int ndis=grid[nx][ny]+dis;
                    // visit[nx][ny]=true;
                    pq.add(new pair(nx,ny,ndis));
                }
            }
        }
        return 0;
    }
    class pair{
        int x;
        int y;
        int cost;
        public pair(int x,int y,int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }
}