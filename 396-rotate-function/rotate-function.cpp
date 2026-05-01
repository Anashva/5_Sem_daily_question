class Solution {
public:
    int maxRotateFunction(vector<int>& nums) {
        int sum=0;
        int f0=0;
        int n=nums.size();
        for(int i=0;i<nums.size();i++){
            sum+=nums[i];
            f0+=i*nums[i];
        }
        int ans=f0;
        int prev=f0;
        for(int i=1;i<n;i++){
            int curr=prev+sum-n*nums[n-i];
            ans=max(ans,curr);
            prev=curr;
        }
        return ans;
    }
};