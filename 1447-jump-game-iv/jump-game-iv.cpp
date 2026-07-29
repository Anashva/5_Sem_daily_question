class Solution {
public:
    int minJumps(vector<int>& arr) {
        unordered_map<int,vector<int>> mp;
        vector<bool>visit(arr.size(),false);
        for(int i=0;i<arr.size();i++){
            mp[arr[i]].push_back(i);
        }
        visit[0]=true;
        queue<int> q;
        q.push(0);
        int step=0;
        while(!q.empty()){
            int s=q.size();
            while(s-->0){
                int idx=q.front();
                q.pop();
                if(idx==arr.size()-1){
                    return step;
                }
                if(idx+1<arr.size() && !visit[idx+1]){
                    visit[idx+1]=true;
                    q.push(idx+1);
                }
                if(idx-1>0 && !visit[idx-1]){
                    visit[idx-1]=true;
                    q.push(idx-1);
                }
                for(auto val:mp[arr[idx]]){
                    if(!visit[val]){
                        visit[val]=true;
                        q.push(val);
                    }
                }
                mp[arr[idx]].clear();
            }
            step++;
        }
        return 0;
    }
};