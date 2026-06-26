class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> ll(numCourses);
        vector<int> deg(numCourses);
        for(auto &e:prerequisites){
            int a=e[0];
            int b=e[1];
            ll[a].push_back(b);
            deg[b]++;
        }
        queue<int> q;
        for(int i=0;i<numCourses;i++){
            if(deg[i]==0){
                q.push(i);
            }
        }
        int c=0;
        while(!q.empty()){
            int r=q.front();
            q.pop();
            c++;
            for(int nbr:ll[r]){
                deg[nbr]--;
                if(deg[nbr]==0){
                    q.push(nbr);
                }
            }
        }
        return c==numCourses;
    }
};