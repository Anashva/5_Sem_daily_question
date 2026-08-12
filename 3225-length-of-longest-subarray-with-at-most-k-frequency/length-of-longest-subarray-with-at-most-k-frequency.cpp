class Solution {
public:
    int maxSubarrayLength(vector<int>& nums, int k) {
        int ans=0;
        int end=0;
        int start=0;
        unordered_map<int,int> mp;
        int n=nums.size();
        while(end<n){
            mp[nums[end]]++;
            while(mp[nums[end]]>k){
                mp[nums[start]]--;
                if(mp[nums[start]]==0){
                    mp.erase(nums[start]);
                }
                start++;
            }
            ans=max(ans,end-start+1);
            end++;
        }
        return ans;
    }
};