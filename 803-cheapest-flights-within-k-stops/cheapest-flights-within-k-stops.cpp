class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<vector<pair<int,int>>> ll(n);
        for(auto &e: flights){
            ll[e[0]].push_back({e[1],e[2]});
        }
        vector<int> dis(n,INT_MAX);
        queue<pair<int,pair<int,int>>> q;
        q.push({0,{src,0}});
        dis[src]=0;
        while(!q.empty()){
            auto step=q.front().first;
            auto [vtx,cost]=q.front().second;
            q.pop();
            // if(dis[vtx]<cost){
            //     continue;
            // }
            if(step>k){
                continue;
            }
            for(auto &e:ll[vtx]){
                int nbr=e.first;
                int ncost=cost+e.second;
                if(dis[nbr]>ncost && step<=k){
                    dis[nbr]=ncost;
                    q.push({step+1,{nbr,ncost}});
                }
            }
        }
        if(dis[dst]!=INT_MAX){
            return dis[dst];
        }
        return -1;

    }
};