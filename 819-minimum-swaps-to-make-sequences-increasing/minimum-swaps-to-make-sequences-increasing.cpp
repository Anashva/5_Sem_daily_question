class Solution {
public:
    unordered_map<long long ,int> dp;
    int minSwap(vector<int>& nums1, vector<int>& nums2) {
        return count(nums1,nums2,-1,-1,0);
    }
    long long make(int prev1,int prev2,int idx){
        return ((long long)(prev1+1) << 42) |((long long)(prev2+1) << 21) | idx;
    }
    int count(vector<int>& nums1,vector<int>&nums2,int prev1,int prev2,int idx){
        if(idx==nums1.size()){
            return 0;
        }
        long long key=make(prev1,prev2,idx);
        if(dp.find(key)!=dp.end()){
            return dp[key];
        }
        int ans=INT_MAX;
        if((prev1==-1 && prev2==-1) || (nums1[idx]>prev1 && nums2[idx]>prev2)){
            ans=count(nums1,nums2,nums1[idx],nums2[idx],idx+1);
        }
        if((prev1==-1 && prev2==-1) || (prev1<nums2[idx] && prev2<nums1[idx])){
            ans=min(ans,1+count(nums1,nums2,nums2[idx],nums1[idx],idx+1));
        }
        return dp[key]=ans;
    }
};