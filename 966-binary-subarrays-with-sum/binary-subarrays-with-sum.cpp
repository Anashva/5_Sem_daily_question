class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        unordered_map<int,int> prefix;
        int c=0;
        int sum=0;
        prefix[0]=1;
        for(int i=0;i<nums.size();i++){
            sum+=nums[i];
            if(prefix.count(sum-goal)){
                c+=prefix[sum-goal];
            }
            prefix[sum]++;
        }
        return c;
    }
};