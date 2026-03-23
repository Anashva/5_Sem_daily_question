class Solution {
public:
    int maximumScore(vector<int>& scores, vector<vector<int>>& edges) {
        int n=scores.size();
        vector<vector<pair<int,int>>> ll(n);
        for(auto &e:edges){
            int u=e[0];
            int v=e[1];
            ll[u].push_back({v,scores[v]});
            ll[v].push_back({u,scores[u]});
        }
        for(int i=0;i<n;i++){
            sort(ll[i].begin(),ll[i].end(),[](auto &a,auto &b){
                return a.second>b.second;
            });
        }
        for(int i=0;i<n;i++){
            if(ll[i].size()>3){
                ll[i].resize(3);
            }
        }
        int ans=-1;
        for(auto &e:edges){
            int u=e[0];
            int v=e[1];
            for(auto &x:ll[u]){
                int X=x.first;
                if(X==v){
                    continue;
                }
                for(auto &y:ll[v]){
                    int Y=y.first;
                    if(Y==X || Y==u){
                        continue;
                    }
                    int total=x.second+y.second+scores[u]+scores[v];
                    ans=max(ans,total);
                }
            }
        }
        return ans;
    }
};