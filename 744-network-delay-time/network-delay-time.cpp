class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<vector<pair<int,int>>> ll(n+1);
        for(auto &e:times){
            ll[e[0]].push_back({e[1],e[2]});
        }
        vector<int> dis(n+1,INT_MAX);
        dis[k]=0;
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
        pq.push({0,k});
        while(!pq.empty()){
            auto[cost,vtx]=pq.top();
            pq.pop();
            if(dis[vtx]<cost){
                continue;
            }
            dis[vtx]=cost;
            for(auto &e:ll[vtx]){
                int nbr=e.first;
                int ncost=cost+e.second;
                if(dis[nbr]>ncost){
                    dis[nbr]=ncost;
                    pq.push({ncost,nbr});
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(dis[i]==INT_MAX){
                return -1;
            }
            ans=max(ans,dis[i]);
        }
        return ans;

    }
};