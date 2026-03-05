class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        int[] degree = new int[n];
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<n;i++){
            if(degree[i]==1 && !hasApple.get(i)){
                q.offer(i);
            }
        }

        int rem = edges.length;

        while(!q.isEmpty()){
            int r = q.poll();
            degree[r]--;
            for(int nbr : graph[r]){
                if(degree[nbr]==0) {
                    continue;
                }
                degree[nbr]--;
                rem--;
                if(nbr!=0 && degree[nbr]==1 && !hasApple.get(nbr)){
                    q.offer(nbr);
                }
            }
        }
        return rem * 2;
    }
}