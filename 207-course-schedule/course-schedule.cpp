class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& pre) {
        vector<int> in(numCourses,0);
        unordered_map<int,vector<int>> mp;
        for(int i=0;i<pre.size();i++){
            int a=pre[i][0];
            int b=pre[i][1];
            mp[a].push_back(b);
            in[b]++;
        }
        queue<int> q;
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                q.push(i);
            }
        }
        int c=0;
        while(!q.empty()){
            int r=q.front();
            q.pop();
            c++;
            for(int nbr:mp[r]){
                in[nbr]--;
                if(in[nbr]==0){
                    q.push(nbr);
                }
            }
        }
        return c==numCourses;
    }
};