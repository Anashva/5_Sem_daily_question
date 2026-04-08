class Solution {
public:
    int xorAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        int mod=pow(10,9)+7;
        for(int i=0;i<queries.size();i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int k=queries[i][2];
            int v=queries[i][3];
            for(int idx=l;idx<=r;idx+=k){
                nums[idx]=(1LL*nums[idx]*v)%mod;
            }
        }
        int ans=0;
        for(auto &val:nums){
            ans^=val;
        }
        return ans;
    }
};