class Solution {
public:
    int minJumps(vector<int>& arr) {
        int n = arr.size();
        unordered_map<int, vector<int>> mp;
        vector<int> visit(n, 0);
        for (int i = 0; i < n; i++) {
            mp[arr[i]].push_back(i);
        }
        queue<int> q;
        q.push(0);
        visit[0] = 1;
        int step = 0;
        while (!q.empty()) {
            int s = q.size();
            while (s-- > 0) {
                int idx = q.front();
                q.pop();
                if (idx == n - 1) {
                    return step;
                }
                if (idx + 1 < n && !visit[idx + 1]) {
                    visit[idx + 1] = 1;
                    q.push(idx + 1);
                }
                if (idx - 1 >= 0 && !visit[idx - 1]) {
                    visit[idx - 1] = 1;
                    q.push(idx - 1);
                }
                for (auto x : mp[arr[idx]]) {
                    if (!visit[x]) {
                        q.push(x);
                        visit[x] = 1;
                    }
                }
                mp[arr[idx]].clear();
            }
            step++;
        }
        return -1;
    }
};