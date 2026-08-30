class Solution {
public:
    int numOfPairs(vector<string>& nums, string targt) {
        int c=0;
        for(int i=0;i<nums.size();i++){
            string s=nums[i];
            for(int j=0;j<nums.size();j++){
                if(i==j){
                    continue;
                }
                string t=nums[j]+s;
                if(t==targt){
                    c++;
                }
            }
        }
        return c;
    }
};   