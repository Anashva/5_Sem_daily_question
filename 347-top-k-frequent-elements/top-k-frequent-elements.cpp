class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        vector<int> ans;
        unordered_map<int,int> mp;
        for(int val:nums){
            mp[val]++;
        }
        priority_queue<pair<int,int>> pq;
        for(auto p:mp){
            pq.push({p.second,p.first});
        }
        while(k-->0){
            ans.push_back(pq.top().second);
            pq.pop();
        }
        return ans;
    }
};