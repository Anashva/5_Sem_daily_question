class Solution {
public:
    int minSwap(vector<int>& nums1, vector<int>& nums2) {
        int n=nums1.size();
        vector<vector<int>> dp(n,vector<int>(2,-1));
        return count(nums1,nums2,0,0,dp);
    }
    int count(vector<int>& nums1,vector<int> &nums2,int idx,int swap,vector<vector<int>> &dp){
        if(idx==nums1.size()){
            return 0;
        }
        if(dp[idx][swap]!=-1){
            return dp[idx][swap];
        }
        int prev1=-1;
        int prev2=-1;
        if(swap==1){
            prev1=nums2[idx-1];
            prev2=nums1[idx-1];
        }
        else if(idx>0){
            prev1=nums1[idx-1];
            prev2=nums2[idx-1];
        }
        int swapp=INT_MAX;
        int noswap=INT_MAX;
        if(prev1<nums1[idx] && prev2<nums2[idx]){
            noswap=count(nums1,nums2,idx+1,0,dp);//no swap
        }
        if(prev1<nums2[idx] && prev2<nums1[idx]){
            swapp=1+count(nums1,nums2,idx+1,1,dp);//swapped
        }
        return dp[idx][swap]=min(swapp,noswap);
    }

};