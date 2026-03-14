class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int m=edgeList.length;
        int q=queries.length;
        Edge[] e=new Edge[m];
        for(int i=0;i<m;i++){
            e[i]=new Edge(edgeList[i][0],edgeList[i][1],edgeList[i][2]);
        }
        Arrays.sort(e,(a,b)->a.dis-b.dis);
        Query[] qr=new Query[q];
        for(int i=0;i<q;i++){
            qr[i]=new Query(queries[i][0],queries[i][1],queries[i][2],i);
        }
        Arrays.sort(qr,(a,b)->a.x-b.x);
        DSU dsu=new DSU(n);
        boolean[] ans=new boolean[q];
        int i=0;
        for(int j=0;j<q;j++){
            while(i<m && e[i].dis<qr[j].x){
                dsu.union(e[i].u,e[i].v);
                i++;
            }
            ans[qr[j].idx]=(dsu.find(qr[j].u)==dsu.find(qr[j].v));
        }
        return ans;

    }
    class Edge{
        int u;
        int v;
        int dis;
        public Edge(int u,int v,int dis){
            this.u=u;
            this.v=v;
            this.dis=dis;
        }
    }
    class Query{
        int u;
        int v;
        int x;
        int idx;
        public Query(int u,int v,int x,int idx){
            this.u=u;
            this.v=v;
            this.x=x;
            this.idx=idx;
        }
    }
    class DSU{
        int[] parent;
        int[] size;
        DSU(int n){
            parent=new int[n];
            size=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        int find(int x){
            if(parent[x]==x){
                return x;
            }
            parent[x]=find(parent[x]);
            return parent[x];
        }
        void union(int a,int b){
            int pa=find(a);
            int pb=find(b);
            if(pa==pb){
                return;
            }
            else if(size[pa]>size[pb]){
                parent[pb]=pa;
                size[pa]+=size[pb];
            }
            else{
                parent[pa]=pb;
                size[pb]+=size[pa];
            }
        }
    }
}