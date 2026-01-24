class Solution {int[] parent;
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent =new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        for(int i=threshold+1;i<=n;i++){
            for(int j=2*i;j<=n;j+=i){
                union(i,j);
            }
        }
        List<Boolean> ll=new ArrayList<>();
        for(int[] r:queries){
            int a=r[0];
            int b=r[1];
            if(find(a)==find(b)){
                ll.add(true);
            }
            else{
                ll.add(false);
            }
        }
        return ll;
    }

    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        parent[x]=find(parent[x]);
        return parent[x];
    }

    public void union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px!=py){
            parent[px]=py;
        }
    }
}