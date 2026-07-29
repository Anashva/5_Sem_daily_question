class Solution {
public:
    bool canReach(vector<int>& arr, int start) {
        vector<bool> vis(arr.size(), false);
        queue<int> q;
        q.push(start);
        vis[start] = true;
        while (!q.empty()) {
            int idx = q.front();
            q.pop();
            if (arr[idx] == 0) {
                return true;
            }
            if (idx - arr[idx] >= 0 && !vis[idx - arr[idx]]) {
                vis[idx - arr[idx]] = true;
                q.push(idx - arr[idx]);
            }
            if (idx + arr[idx] < arr.size() && !vis[idx + arr[idx]]) {
                vis[idx + arr[idx]] = true;
                q.push(idx + arr[idx]);
            }
        }
        return false;
    }
};