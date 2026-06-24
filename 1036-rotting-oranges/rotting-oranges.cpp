class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid){
        queue<pair<int, int>> q;
        int n = grid.size();
        int m = grid[0].size();
        int one = 0;
        vector<vector<int>> dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.push({i, j});
                } else if (grid[i][j] == 1) {
                    one++;
                }
            }
        }
        int ans = 0;
        while (!q.empty() && one>0) {
            int s = q.size();
            while (s-- > 0) {
                auto [r, c] = q.front();
                q.pop();
                for (int i = 0; i < 4; i++) {
                    int nr = r + dir[i][0];
                    int nc = c + dir[i][1];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= m || grid[nr][nc] == 0){
                        continue;
                    }
                    if (grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        one--;
                        q.push({nr, nc});
                    }
                }
            }
            ans++;
        }
        return one == 0 ? ans : -1;
    }
};