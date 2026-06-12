class Solution {
public:
    int depth=0;
    int mod=1e9+7;
    int assignEdgeWeights(vector<vector<int>>& edges) {
        int mx = 0;
        for (auto &e : edges) {
            mx = max(mx, max(e[0], e[1]));
        }

        vector<vector<int>> ll(mx + 1);
         for (auto &e : edges) {
            int u = e[0];
            int v = e[1];

            ll[u].push_back(v);
            ll[v].push_back(u);
        }
        dpth(ll,1,-1,0);
        depth--;
        long long  ans=powr(2,depth);
        return ans;
    }
    void dpth(vector<vector<int>> & edges,int u,int v,int curr){
        depth=max(depth,curr);
        for(int nbr:edges[u]){
            if(nbr==v){
                continue;
            }
            dpth(edges,nbr,u,curr+1);
        }
    }
    long long powr(long long a,long long b){
        long long ans=1;
        while(b){
            if(b & 1){
                ans=(ans*a)%mod;
            }
            a=(a*a)%mod;
            b>>=1;
        }
        return ans;
    }
};