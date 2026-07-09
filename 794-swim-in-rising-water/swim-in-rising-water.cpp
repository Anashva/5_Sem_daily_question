class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        int n=grid.size();
        priority_queue<pair<int,pair<int,int>>,vector<pair<int,pair<int,int>>>,greater<pair<int,pair<int,int>>>> pq;
        vector<vector<int>> vis(n,vector<int>(n,0));
        vis[0][0]=1;
        pq.push({grid[0][0],{0,0}});
        vector<vector<int>> dir{{-1,0},{1,0},{0,1},{0,-1}};
        while(!pq.empty()){
            auto time=pq.top().first;
            auto [x,y]=pq.top().second;
            pq.pop();
            if(x==n-1 && y==n-1){
                return time;
            }
            for(int i=0;i<4;i++){
                int nx=x+dir[i][0];
                int ny=y+dir[i][1];
                if(nx>=0 && nx<n && ny>=0 && ny<n && !vis[nx][ny]){
                    pq.push({max(time,grid[nx][ny]),{nx,ny}});
                    vis[nx][ny]=1;
                }
            }
        }
        return 0;
    }
};