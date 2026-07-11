class Solution {
public:
    int countCompleteComponents(int n, vector<vector<int>>& edges) {
        vector<vector<int>> ll(n);
        for(auto &e:edges){
            ll[e[0]].push_back(e[1]);
            ll[e[1]].push_back(e[0]);
        }
        return count(n,ll);
    }
    int count(int n, vector<vector<int>> &ll){
        queue<int> q;
        set<int> st;
        int c=0;
        for(int i=0;i<n;i++){
            if(st.count(i)){
                continue;
            }
            int v=0;
            int e=0;
            q.push(i);
            while(!q.empty()){
                int r=q.front();
                q.pop();
                if(st.count(r)){
                    continue;
                }
                v++;
                st.insert(r);
                for(int nbr:ll[r]){
                    e++;
                    if(!st.count(nbr)){
                        q.push(nbr);
                    }
                }
            }
            if(e/2==v*(v-1)/2){
                c++;
            }

        }
        return c;
    }
};