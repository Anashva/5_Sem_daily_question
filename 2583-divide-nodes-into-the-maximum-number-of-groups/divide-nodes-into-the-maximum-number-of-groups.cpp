class Solution {
public:
    int magnificentSets(int n, vector<vector<int>>& edges) {
        vector<vector<int>> ll(n + 1);
        for (auto& e : edges) {
            ll[e[0]].push_back(e[1]);
            ll[e[1]].push_back(e[0]);
        }
        queue<pair<int, int>> q;
        unordered_map<int, int> mp;
        for (int i = 1; i <= n; i++) {
            if (mp.count(i)) {
                continue;
            }
            q.push({i, 0});
            while (!q.empty()) {
                auto [vtx, dis] = q.front();
                q.pop();
                if (mp.count(vtx)) {
                    if (mp[vtx] != dis) {
                        return -1;
                    }
                    continue;
                }
                mp[vtx] = dis;
                for (int nbr : ll[vtx]) {
                    if (!mp.count(nbr)) {
                        q.push({nbr, dis + 1});
                    }
                }
            }
        }

        vector<int> level(n + 1);
        for (int i = 1; i <= n; i++) {
            queue<int> Q;
            vector<int> dis(n + 1, -1);
            Q.push(i);
            dis[i] = 0;
            int l = 0;
            while (!Q.empty()) {
                int s = Q.size();
                l++;
                while (s-- > 0) {
                    int r = Q.front();
                    Q.pop();
                    for (int nbr : ll[r]) {
                        if (dis[nbr] == -1) {
                            dis[nbr] = dis[r] + 1;
                            Q.push(nbr);
                        }
                    }
                }
            }
            level[i] = l;
        }
        int ans = 0;
        // unordered_set<int> st;
        vector<bool> dis(n+1);
        for (int i = 1; i <= n; i++) {
            if (dis[i]) {
                continue;
            }
            queue<int> Q;
            Q.push(i);
            dis[i]=true;
            int c = 0;
            while (!Q.empty()) {
                int r = Q.front();
                Q.pop();
                c = max(c, level[r]);
                for (int nbr : ll[r]) {
                    if (!dis[nbr]) {
                        dis[nbr]=true;
                        Q.push(nbr);
                    }
                }
            }
            ans += c;
        }
        return ans;
    }
};

// maximum group=bfs level
// from every component we find maximum level as start bfs for every node for
// finding maximum level