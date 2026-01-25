class Solution {
    List<Integer>[] mp;
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        mp=new ArrayList[n];
        for(int i=0;i<n;i++){
            mp[i]=new ArrayList<>();
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            mp[u].add(v);
            mp[v].add(u);
        }
        int[] dis1=bfs(n,x);
        int[] dis2=bfs(n,y);
        int[] dis3=bfs(n,z);
        int ans=0;
        for(int i=0;i<n;i++){
            int[] nums={dis1[i],dis2[i],dis3[i]};
            Arrays.sort(nums);
            int a=nums[0];
            int b=nums[1];
            int c=nums[2];
            if(a*a+b*b==c*c){
                ans++;
            }
        }
        return ans;
    }
    public int[] bfs(int n,int src){
        int[] dis=new int[n];
        Arrays.fill(dis,-1);
        dis[src]=0;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{src,0});
        while(!q.isEmpty()){
            int[] rp=q.poll();
            int r=rp[0];
            for(int nbr:mp[r]){
                if(dis[nbr]==-1){
                    dis[nbr]=dis[r]+1;
                    q.add(new int[]{nbr,dis[nbr]});
                }
            }
        }
        return dis;
    }
}