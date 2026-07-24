class Solution {
public:
    vector<int> ll;
    vector<vector<int>> ans;
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        solve(nums,0);
        return ans;
    }
    void solve(vector<int>& nums,int idx){
        ans.push_back(ll);
        for(int i=idx;i<nums.size();i++){
            if(i>idx && nums[i]==nums[i-1]){
                continue;
            }
            ll.push_back(nums[i]);
            solve(nums,i+1);
            ll.pop_back();
        }
    }
};