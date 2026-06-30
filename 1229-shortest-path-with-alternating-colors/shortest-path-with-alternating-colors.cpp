class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges,
                                         vector<vector<int>>& blueEdges) {
        vector<vector<pair<int, int>>> ll(n);
        for (auto& e : redEdges) {
            ll[e[0]].push_back({e[1], 0});
        }
        for (auto& e : blueEdges) {
            ll[e[0]].push_back({e[1], 1});
        }
        queue<pair<int, int>> q;
        vector<int> dis(n, -1);
        vector<vector<int>> vis(n, vector<int>(2, 0));
        q.push({0, 1});
        q.push({0, 0});
        dis[0] = 0;
        vis[0][0] = vis[0][1] = 1;
        int l = 0;
        while (!q.empty()) {
            int size = q.size();
            while (size-- > 0) {
                auto [vtx, color] = q.front();
                q.pop();
                if(dis[vtx]==-1){
                    dis[vtx]=l;
                }
                for (auto [nbr, nc] : ll[vtx]) {
                    if (color == nc || vis[nbr][nc]) {
                        continue;
                    }
                    vis[nbr][nc] = 1;
                    q.push({nbr, nc});
                }
            }
            l++;
        }
        return dis;
    }
};