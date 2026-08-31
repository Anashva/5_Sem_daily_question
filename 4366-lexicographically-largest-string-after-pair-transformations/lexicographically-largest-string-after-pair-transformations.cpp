class Solution {
public:
    vector<string> largestString(vector<int>& nums) {
        vector<string> ans;
        for(int x:nums){
            string s;
            for(int bit=25;bit>=0;bit--){
                while(x>=(1<<bit)){
                    s.push_back('a'+bit); 
                    x-=(1<<bit);
                }
            }
            ans.push_back(s);
        }
        return ans;
    }
};