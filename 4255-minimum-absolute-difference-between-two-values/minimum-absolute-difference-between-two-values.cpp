class Solution {
public:
    int minAbsoluteDifference(vector<int>& nums) {
        int one=-1;
        int two=-1;
        int ans=INT_MAX;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==1){
                if(two!=-1){
                    ans=min(ans,abs(i-two));
                }
                one=i;
            }
            else if(nums[i]==2){
                if(one!=-1){
                    ans=min(ans,abs(i-one));
                }
                two=i;
            }
        }
        return ans==INT_MAX ? -1 : ans;
    }
};