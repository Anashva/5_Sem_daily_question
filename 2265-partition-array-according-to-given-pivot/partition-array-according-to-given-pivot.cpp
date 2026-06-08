class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        int n=nums.size();
        vector<int> ans(n);
        int i=0;
        int j=n-1;
        for(int d=0;d<n;d++){
            if(nums[d]<pivot){
                ans[i++]=nums[d];
            }
        }
        for(int d=n-1;d>=0;d--){
            if(nums[d]>pivot){
                ans[j--]=nums[d];
            }
        }
        for(int x:nums){
            if(x==pivot){
                ans[i++]=x;
            }
        }
        return ans;
    }
};