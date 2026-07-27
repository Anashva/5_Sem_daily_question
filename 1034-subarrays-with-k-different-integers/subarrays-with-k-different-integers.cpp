class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
    int solve(vector<int>& nums, int k){
        int ans=0;
        int end=0;
        int start=0;
        unordered_map<int,int> mp;
        while(end<nums.size()){
            mp[nums[end]]++;
            while(mp.size()>k){
                mp[nums[start]]--;
                if(mp[nums[start]]==0){
                    mp.erase(nums[start]);
                }
                start++;
            }
            ans+=end-start+1;
            end++;
        }
        return ans;
    }
};