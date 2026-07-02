class Solution {
public:
    bool findSafeWalk(vector<vector<int>>& grid, int health) {
        int n = grid.size();
        int m = grid[0].size();
        vector<int> row{-1, 1, 0, 0};
        vector<int> col{0, 0, -1, 1};
        priority_queue<pair<int, pair<int, int>>> q;
        q.push({health - grid[0][0], {0, 0}});
        vector<vector<int>> dis(n, vector<int>(m, -1));
        dis[0][0] = health - grid[0][0];
        while (!q.empty()) {
            auto cost = q.top().first;
            auto [r,c] = q.top().second;
            q.pop();
            if (r == n - 1 && c == m - 1) {
                return cost >= 1;
            }
            if (dis[r][c] > cost) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + row[i];
                int nc = c + col[i];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    int newc = cost - grid[nr][nc];
                    if (newc > 0 && newc > dis[nr][nc]) {
                        dis[nr][nc] = newc;
                        q.push({cost - grid[nr][nc], {nr, nc}});
                    }
                }
            }
        }
        return false;
    }
};