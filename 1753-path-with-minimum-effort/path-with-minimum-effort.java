class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dis=new int[heights.length][heights[0].length];
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        for(int[] a:dis){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        pq.add(new pair(0,0,0));
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        dis[0][0]=0;
        while(!pq.isEmpty()){
            pair rp=pq.poll();
            int x=rp.x;
            int y=rp.y;
            int cost=rp.cost;
            if(x==heights.length-1 && y==heights[0].length-1){
                return cost;
            }
            if(dis[x][y]<cost){
                continue;
            }
            dis[x][y]=cost;
            for(int[] d:dir){
                int nx=d[0]+x;
                int ny=d[1]+y;
                if(nx>=0 && ny>=0 && nx<heights.length && ny<heights[0].length){
                    int diff=Math.abs(heights[x][y]-heights[nx][ny]);
                    if(dis[nx][ny]>Math.max(cost,diff)){
                        dis[nx][ny]=Math.max(cost,diff);
                        pq.add(new pair(nx,ny,dis[nx][ny]));
                    }
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