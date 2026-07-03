class Solution {
public:
    int n;
    int findMaxPathScore(vector<vector<int>>& edges, vector<bool>& online, long long k) {
        n=online.size();
        int l=0;
        int h=INT_MAX;
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            vector<vector<pair<int,long long>>> ll(n);
            for(auto &e:edges){
                if(e[2]>=mid && online[e[0]] && online[e[1]]){
                    ll[e[0]].push_back({e[1],e[2]});
                }
            }
            long long  res=dijkstra(ll);
            if(res<=k){
                    ans=mid;
                    l=mid+1;
                }
            else{
                    h=mid-1;
                }
        }
        return ans;
    }
    long long dijkstra( vector<vector<pair<int,long long>>> &ll){
        vector<long long> dis(n,LLONG_MAX/4);
        dis[0]=0;
        priority_queue<pair<long long,int>,vector<pair<long long,int>>,greater<pair<long long,int>>> pq;
        pq.push({0,0});
        while(!pq.empty()){
            auto [cost,vtx]=pq.top();
            pq.pop();
            if(vtx==n-1){
                return cost;
            }
            if(cost>dis[vtx]){
                continue;
            }
            for(auto &it:ll[vtx]){
                int nbr=it.first;
                long long ncost=cost+it.second;
                if(ncost<dis[nbr]){
                    dis[nbr]=ncost;
                    pq.push({ncost,nbr});
                }
            }
        }
        return LLONG_MAX/4;
    }
};