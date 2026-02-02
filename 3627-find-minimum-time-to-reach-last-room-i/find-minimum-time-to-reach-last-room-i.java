class Solution {
    public int minTimeToReach(int[][] grid) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n=grid.length;
        int m=grid[0].length;
        pq.add(new int[]{0,0,0});
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        int[][] dis=new int[n][m];
        for(int[] a:dis){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        dis[0][0]=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int x=curr[1];
            int y=curr[2];
            int cost=curr[0];
            if(cost>dis[x][y]){
                continue;
            }
            if(x==n-1 && y==m-1){
                return cost;
            }
            dis[x][y]=cost;
            for(int[] d:dir){
                int nx=d[0]+x;
                int ny=d[1]+y;
                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    int ncost=Math.max(cost,grid[nx][ny])+1;
                    // pq.add(new int[]{ncost,nx,ny});
                    if(ncost < dis[nx][ny]){ 
                        dis[nx][ny] = ncost; 
                        pq.add(new int[]{ncost, nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}