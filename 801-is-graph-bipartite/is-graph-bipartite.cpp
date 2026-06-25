class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        unordered_map<int,int> mp;
        queue<pair<int,int>>q;
        for(int i=0;i<graph.size();i++){
            if(mp.count(i)){
                continue;
            }
            q.push({i,0});
            while(!q.empty()){
                auto [vtx,dis]=q.front();
                q.pop();
                if(mp.count(vtx)){
                    if(mp[vtx]!=dis){
                        return false;
                    }
                    continue;
                }
                mp[vtx]=dis;
                for(int nbr:graph[vtx]){
                    if(!mp.count(nbr)){
                        q.push({nbr,dis+1});
                    }
                }
            }
        }
        return true;
    }
};