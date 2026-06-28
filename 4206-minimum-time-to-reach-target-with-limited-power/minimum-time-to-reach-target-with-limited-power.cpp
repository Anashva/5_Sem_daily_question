class Solution {
public:
    vector<long long> minTimeMaxPower(int n, vector<vector<int>>& edges, int power, vector<int>& cost, int source, int target){
        if(source==target){
            return {0,power};
        }
        vector<vector<pair<int,int>>> ll(n);
        for(auto &e: edges){
            int u=e[0];
            int v=e[1];
            int t=e[2];
            ll[u].push_back({v,t});
        }
        const long long INF=1e15;
        vector<vector<long long>> dis(n,vector<long long>(power+1,INF));
        priority_queue<pair<long long,pair<int,int>>,vector<pair<long long,pair<int,int>>>,greater<pair<long long,pair<int,int>>>> pq;
        pq.push({0,{source,power}});
        dis[source][power]=0;
        while(!pq.empty()){
            auto curr=pq.top();
            pq.pop();
            long long time=curr.first;
            int vtx=curr.second.first;
            int rempower=curr.second.second;

            if(time>dis[vtx][rempower]){
                continue;
            }
            for(auto &e:ll[vtx]){
                int nbr=e.first;
                int etime=e.second;
                if(rempower<cost[vtx]){
                    continue;
                }
                int npower=rempower-cost[vtx];
                long long ntime=time+etime;
                if(ntime<dis[nbr][npower]){
                    dis[nbr][npower]=ntime;
                    pq.push({ntime,{nbr,npower}});
                }
            }
        }
        long long Time=INF;
        int Power=0;
        for(int i=0;i<=power;i++){
            if(dis[target][i]<Time){
                Time=dis[target][i];
                Power=i;
            }
            else if(dis[target][i]==Time){
                Power=max(Power,i);
            }
        }
        if(Time == INF){
            return {-1,-1};
        }
        return {Time, Power};
    }

};