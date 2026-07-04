class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {

        vector<vector<pair<int,int>>> g(n+1);

        for (auto &e : roads) {
            g[e[0]].push_back({e[1], e[2]});
            g[e[1]].push_back({e[0], e[2]});
        }

        vector<int> vis(n+1, 0);
        queue<int> q;

        q.push(1);
        vis[1] = 1;

        int ans = INT_MAX;

        while (!q.empty()) {
            int node = q.front();
            q.pop();

            for (auto &[nbr, wt] : g[node]) {
                ans = min(ans, wt);

                if (!vis[nbr]) {
                    vis[nbr] = 1;
                    q.push(nbr);
                }
            }
        }

        return ans;
    }
};