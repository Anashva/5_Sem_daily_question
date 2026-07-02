class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        int n=heights.size();
        int m=heights[0].size();
        vector<vector<int>> dis(n,vector<int>(m,INT_MAX));
        priority_queue<pair<int,pair<int,int>>,vector<pair<int,pair<int,int>>>,greater<pair<int,pair<int,int>>>> pq;
        pq.push({0,{0,0}});
        dis[0][0]=0;
        vector<int> row{-1,1,0,0};
        vector<int> col{0,0,-1,1};
        while(!pq.empty()){
            auto cost=pq.top().first;
            auto [r,c]=pq.top().second;
            pq.pop();
            if(r==n-1 && c==m-1){
                return cost;
            }
            if(cost>dis[r][c]){
                continue;
            }
            for(int i=0;i<4;i++){
                int nr=r+row[i];
                int nc=c+col[i];
                if(nr<0 || nc<0 || nr>=n || nc>=m){
                    continue;
                }
                int diff=abs(heights[nr][nc]-heights[r][c]);
                int ncost=max(diff,cost);
                if(ncost<dis[nr][nc]){
                    dis[nr][nc]=ncost;
                    pq.push({ncost,{nr,nc}});
                }
            }
        }
        return -1;

    }
    
};