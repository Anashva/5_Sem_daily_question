class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        unordered_map<int,unordered_map<int,int>> mp;
        for(auto &e: times){
            int u=e[0];
            int v=e[1];
            int wt=e[2];
            mp[u][v]=wt;
        }
        vector<int> dis(n+1,INT_MAX);
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
        pq.push({0,k});
        dis[k]=0;
        while(!pq.empty()){
            auto rp=pq.top();
            pq.pop();
            int wt=rp.first;
            int vtx=rp.second;
            if(dis[vtx]<wt){
                continue;
            }
            dis[vtx]=wt;
            for(auto &e: mp[vtx]){
                int cost=e.second+wt;
                int nbr=e.first;
                if(dis[nbr]>cost){
                    dis[nbr]=cost;
                    pq.push({cost,nbr});
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