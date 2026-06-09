class Solution {
public:
    long long maxTotalValue(vector<int>& nums, int k) {
        long long ans=0;
        int mx=INT_MIN;
        int mn=INT_MAX;
        for(int x:nums){
            mx=max(mx,x);
            mn=min(mn,x);
        }
        long diff=mx-mn;
        ans=k*diff;
        return ans;
    }
};