class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n=graph.size();
        vector<int> in(n);
        vector<vector<int>> ll(n);
        for(int i=0;i<n;i++){
            for(int x:graph[i]){
                ll[x].push_back(i);
                in[i]++;
            }
        }
        queue<int>q;
        for(int i=0;i<n;i++){
            if(in[i]==0){
                q.push(i);
            }
        }
        vector<int> ans;
        while(!q.empty()){
            int r=q.front();
            q.pop();
            ans.push_back(r);
            for(int nbr:ll[r]){
                in[nbr]--;
                if(in[nbr]==0){
                    q.push(nbr);
                }
            }
        }
        sort(ans.begin(),ans.end());
        return ans;
    }
};