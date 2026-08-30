class Solution {
public:
    int numOfPairs(vector<string>& nums, string targt) {
        // int c=0;
        // for(int i=0;i<nums.size();i++){
        //     string s=nums[i];
        //     for(int j=0;j<nums.size();j++){
        //         if(i==j){
        //             continue;
        //         }
        //         string t=nums[j]+s;
        //         if(t==targt){
        //             c++;
        //         }
        //     }
        // }
        // return c;

        unordered_map<string,int> mp;
        int ans=0;
        for(int i=0;i<nums.size();i++){
            if(targt.starts_with(nums[i])){
                string s=targt.substr(nums[i].size());
                if(mp.count(s)){
                    ans+=mp[s];
                }
            }
            if(targt.ends_with(nums[i])){
                string s=targt.substr(0,targt.size()-nums[i].size());
                if(mp.count(s)){
                    ans+=mp[s];
                }
            }
            mp[nums[i]]++;
            
        }
        return ans;
    }
};   