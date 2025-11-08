class Solution {
    int mod=(int)1e9+7;
    long [][] mindp;
    long [][] maxdp;
    boolean[][] visit;
    public int maxProductPath(int[][] grid) {
        // path(grid,0,0,1);
        // if(ans<0){
        //     return -1;
        // }
        // return (int) ((ans % mod + mod) % mod);
        int n = grid.length, m = grid[0].length;
        mindp=new long[n][m];
        maxdp=new long[n][m];
        visit=new boolean[n][m];
        Pair ans=prod(grid,0,0);
        if(ans.max<0){
            return -1;
        }
        return (int) (ans.max % mod);
    }
    public void path(int[][] grid,int cr,int cc,long prod){
        if(cr>=grid.length || cc>=grid[0].length){
            return;
        }
        if(cr==grid.length-1 && cc==grid[0].length-1){
            prod=prod*grid[cr][cc];
            // ans=Math.max(ans,prod);
            return;
        }
        path(grid,cr,cc+1,prod*grid[cr][cc]);
        path(grid,cr+1,cc,prod*grid[cr][cc]);
    }
    class Pair{
        long min;
        long max;
        Pair(long min, long max){
            this.min=min;
            this.max=max;
        }
    }
    public Pair prod(int[][] grid,int cr,int cc){
        if(cr==grid.length-1 && cc==grid[0].length-1){
            return new Pair(grid[cr][cc],grid[cr][cc]);
        }
        if(visit[cr][cc]){
            return new Pair(mindp[cr][cc],maxdp[cr][cc]);
        }
        long max=Integer.MIN_VALUE;
        long min=Integer.MAX_VALUE;
        
        // right
        if(cc+1<grid[0].length){
            Pair r=prod(grid,cr,cc+1);
            max=Math.max(max,Math.max(r.max*grid[cr][cc],r.min*grid[cr][cc]));
            min=Math.min(min,Math.min(r.max*grid[cr][cc],r.min*grid[cr][cc]));
        }
        // down
        if(cr+1<grid.length){
            Pair d=prod(grid,cr+1,cc);
            max=Math.max(max,Math.max(d.max*grid[cr][cc],d.min*grid[cr][cc]));
            min=Math.min(min,Math.min(d.max*grid[cr][cc],d.min*grid[cr][cc]));
        }
        mindp[cr][cc]=min;
        maxdp[cr][cc]=max;
        visit[cr][cc]=true;
        return  new Pair(min,max);
    }
}