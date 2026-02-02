class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new pair(0,0,0));
        int[][] dis=new int[n][m];
        for(int[] a:dis){
            Arrays.fill(a,Integer.MAX_VALUE);
        }

        dis[0][0]=0;
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        while(!pq.isEmpty()){
            pair rp=pq.poll();
            int x=rp.x;
            int y=rp.y;
            int cost=rp.cost;
            if(x==n-1 && y==m-1){
                return cost;
            }
            if(cost>dis[x][y]){
                continue;
            }
            // dis[x][y]=cost;
            for(int[] d:dir){
                int nx=d[0]+x;
                int ny=d[1]+y;
                if(nx>=0 && ny>=0 && nx<n && ny<m ){
                    int ncost = cost + 1;
                    if (ncost < grid[nx][ny]) {
                        int wait = grid[nx][ny] - ncost;//how early it arrived 
                        if (wait % 2 == 1)
                            ncost = grid[nx][ny] + 1;
                        else
                            ncost = grid[nx][ny];//every back and forth it will increase its value by even time
                    }

                    if (ncost < dis[nx][ny]) {
                        dis[nx][ny] = ncost;
                        pq.add(new pair(nx, ny, ncost));
                    }
                }
            }
        }
        return -1;
    }
    class pair{
        int x;
        int y;
        int cost;
        pair(int x,int y,int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }
}