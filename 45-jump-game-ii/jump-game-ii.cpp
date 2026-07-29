class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.size()==1){
            return 0;
        }
        int count=0;
        int step=0;
        int mx=0;
        for(int i=0;i<nums.size()-1;i++){
            mx=max(mx,nums[i]+i);
            if(step==i){
                count++;
                step=mx;
            }
        }
        return count;
    }
};