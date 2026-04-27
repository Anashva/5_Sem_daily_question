class Solution {
public:
    bool hasValidPath(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        vector<vector<bool>> vis(n,vector<bool>(m,false));
        queue<vector<int>>q;
         vector<vector<vector<int>>> dir= {
            {},
            {{0,-1},{0,1}},
            {{-1,0},{1,0}},
            {{0,-1},{1,0}},
            {{0,1},{1,0}},
            {{0,-1},{-1,0}},
            {{0,1},{-1,0}}
        };
        
        vis[0][0]=true;
        q.push({0,0});
        while(!q.empty()){
            vector<int> rp=q.front();
            q.pop();
            int r=rp[0];
            int c=rp[1];
            if(r==n-1 && c==m-1){
                return true;
            }
            for(auto &d: dir[grid[r][c]]){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr<0 || nc<0 || nr>=n || nc>=m || vis[nr][nc]){
                    continue;
                }
                for(auto &rv:dir[grid[nr][nc]]){
                    if(nr+rv[0]==r && nc+rv[1]==c){
                        vis[nr][nc]=true;
                        q.push({nr,nc});
                    }
                }
            }
        }
        return false;
    }
};