class Solution {
public:
    int missingInteger(vector<int>& nums) {
        int sum=nums[0];
        unordered_set<int>st;
        for(int x:nums){
            st.insert(x);
        }
        for(int i=1;i<nums.size();i++){
            if(nums[i]==nums[i-1]+1){
                sum+=nums[i];
            }
            else{
                break;
            }
        }
        while(st.count(sum)){
            sum++;
        }
        return sum;
    }
};