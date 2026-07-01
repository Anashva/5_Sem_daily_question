class Solution {
public:
    int maximumSafenessFactor(vector<vector<int>>& grid) {
        int n = grid.size();
        if (grid[n - 1][n - 1] == 1) {
            return 0;
        }
        vector<vector<int>> dis(n, vector<int>(n, INT_MAX));
        queue<pair<int, int>> q;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dis[i][j] = 0;
                    q.push({i, j});
                }
            }
        }

        vector<int> row = {0,0,-1,1};
        vector<int> col = {-1,1,0,0};



        while (!q.empty()) {
            auto [r, c] = q.front();
            q.pop();
            for (int i = 0; i < 4; i++) {
                int nr = r + row[i];
                int nc = c + col[i];

                if (nr >= 0 && nc < n && nc >= 0 && nr < n &&
                    dis[nr][nc] > 1 + dis[r][c]) {
                    dis[nr][nc] = 1 + dis[r][c];
                    q.push({nr, nc});
                }
            }
        }
        vector<vector<bool>> vis(n, vector<bool>(n, false));
        priority_queue<pair<int, pair<int, int>>> pq;
        pq.push({dis[0][0], {0, 0}});
        while (!pq.empty()) {
            auto cost = pq.top().first;
            auto [r, c] = pq.top().second;
            pq.pop();
            if (r == n - 1 && c == n - 1) {
                return cost;
            }
            if(vis[r][c]){
                continue;
            }

            vis[r][c] = true;
            for (int i = 0; i < 4; i++) {
                int nr = r + row[i];
                int nc = c + col[i];

                if (nr >= 0 && nc < n && nc >= 0 && nr < n && !vis[nr][nc]) {
                    int s = min(cost, dis[nr][nc]);
                    pq.push({s, {nr, nc}});
                    vis[r][c] = true;
                }
            }
        }
        return 0;
    }
};