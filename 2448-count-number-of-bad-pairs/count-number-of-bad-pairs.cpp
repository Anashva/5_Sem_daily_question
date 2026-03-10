class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        long long ans=0;
        int n=nums.size();
        long long total=(long long)n*(n-1)/2;
        unordered_map<int,long long> mp;
        for(int i=0;i<n;i++){
            mp[nums[i]-i]++;
        }
        for(auto v:mp){
            if(v.second>1){
                ans+=v.second*(v.second-1)/2;
            }
        }
        return total-ans;
    }
};