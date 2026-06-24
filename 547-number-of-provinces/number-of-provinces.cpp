class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n=isConnected.size();
        vector<vector<int>> ll(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    ll[i].push_back(j);
                    ll[j].push_back(i);
                }
            }
        }
        return component(ll,n);
    }
    int component(vector<vector<int>> &ll,int n){
        set<int> st;
        queue<int> q;
        int c=0;
        for(int i=0;i<n;i++){
            if(st.count(i)){
                continue;
            }
            c++;
            q.push(i);
            while(!q.empty()){
                int r=q.front();
                q.pop();
                if(st.count(r)){
                    continue;
                }
                st.insert(r);
                for(int nbr:ll[r]){
                    if(!st.count(nbr)){
                        q.push(nbr);
                    }
                }
            }
        }
        return c;
    }
};