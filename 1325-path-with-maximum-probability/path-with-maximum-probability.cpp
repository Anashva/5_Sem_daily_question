class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        // unordered_map<int,unordered_map<int,double>> mp;
        // for(int i=0;i<edges.size();i++){
        //     mp[edges[i][0]][edges[i][1]]=succProb[i];
        //     mp[edges[i][1]][edges[i][0]]=succProb[i];
        // }

        vector<vector<pair<int,double>>> ll(n);
        for(int i=0;i<edges.size();i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double wt=succProb[i];
            ll[u].push_back({v,wt});
            ll[v].push_back({u,wt});
        }
        priority_queue<pair<double,int>> pq;
        pq.push({1.0,start});
        set<int> st;
        while(!pq.empty()){
            auto[cost,vtx]=pq.top();
            pq.pop();
            if(vtx==end){
                return cost;
            }
            if(st.count(vtx)){
                continue;
            }
            st.insert(vtx);
            for(auto &e: ll[vtx]){
                int nbr=e.first;
                double ncost=e.second*cost;
                if(!st.count(nbr)){
                    pq.push({ncost,nbr});
                }
            }
        }
        return 0.0;
    }
};