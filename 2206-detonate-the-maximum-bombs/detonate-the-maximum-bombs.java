import java.util.*;

class Solution {
    List<Integer>[] ll;

    public int maximumDetonation(int[][] bombs) {
        int ans = 0;
        int n = bombs.length;

        ll = new ArrayList[n];
        for(int i=0;i<n;i++){
            ll[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];

            for(int j=0;j<n;j++){
                if(i==j) continue;

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long dx = x2 - x1;
                long dy = y2 - y1;

                long dis = dx*dx + dy*dy;

                if(dis <= r1*r1){
                    ll[i].add(j);
                }
            }
        }

        for(int i=0;i<n;i++){
            ans = Math.max(ans, bfs(i,n));
        }

        return ans;
    }

    public int bfs(int src,int n){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n];

        int c = 1;
        visit[src] = true;
        q.add(src);

        while(!q.isEmpty()){
            int r = q.poll();

            for(int nbr: ll[r]){
                if(!visit[nbr]){
                    visit[nbr] = true;
                    c++;
                    q.add(nbr);
                }
            }
        }

        return c;
    }
}