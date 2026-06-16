class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        return count(nums,0,target);
    }
    int count(vector<int> & nums,int idx,int target){
        if(target==0 && idx==nums.size()){
            return 1;
        }
        if(target!=0 && idx==nums.size()){
            return 0;
        }
        int ans=0;
        ans+=count(nums,idx+1,target-nums[idx]);
        ans+=count(nums,idx+1,target+nums[idx]);
        return ans;
    }
};